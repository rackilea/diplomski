package nhenneaux.test.swagger.ext;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.JavaType;

import io.swagger.annotations.ApiModel;
import io.swagger.converter.ModelConverter;
import io.swagger.converter.ModelConverterContext;
import io.swagger.jackson.ModelResolver;
import io.swagger.models.Model;
import io.swagger.models.ModelImpl;
import io.swagger.models.properties.Property;
import io.swagger.models.properties.RefProperty;
import io.swagger.models.properties.StringProperty;
import io.swagger.util.Json;

public class EnumAsModelAwareResolver extends ModelResolver {
    static final EnumAsModelAwareResolver INSTANCE = new EnumAsModelAwareResolver();

    public EnumAsModelAwareResolver() {
        super(Json.mapper());
    }

    @Override
    public Property resolveProperty(Type type, ModelConverterContext context, Annotation[] annotations,
            Iterator<ModelConverter> chain) {
        if (isEnumAnApiModel(type)) {
            String name = findName(type);
            // ask context to resolver enum type (for adding model definition
            // for enum under definitions section
            context.resolve(type);

            return new RefProperty(name);
        }
        return chain.next().resolveProperty(type, context, annotations, chain);
    }

    private String findName(Type type) {
        JavaType javaType = _mapper.constructType(type);
        Class<?> rawClass = javaType.getRawClass();
        ApiModel annotation = rawClass.getAnnotation(ApiModel.class);
        String name = annotation.value();
        if (name == null || name.length() == 0) {
            name = rawClass.getSimpleName();
        }
        return name;
    }

    private boolean isEnumAnApiModel(Type type) {
        JavaType javaType = _mapper.constructType(type);
        return javaType.isEnumType()
                && javaType.getRawClass().isAnnotationPresent(ApiModel.class);
    }

    @Override
    public Model resolve(Type type, ModelConverterContext context, Iterator<ModelConverter> chain) {
        JavaType javaType = Json.mapper().constructType(type);
        if (javaType.isEnumType()) {
            ModelImpl model = new ModelImpl();
            Class<?> rawClass = javaType.getRawClass();
            ApiModel annotation = rawClass.getAnnotation(ApiModel.class);
            String name = annotation.value();
            if (name == null || name.length() == 0) {
                name = rawClass.getSimpleName();
            }
            model.setName(name);
            model.setDescription(annotation.description());
            model.setType(StringProperty.TYPE);

            List<String> constants = findEnumConstants(rawClass);
            model.setEnum(constants);
            return model;
        }
        return chain.next().resolve(type, context, chain);
    }

    private List<String> findEnumConstants(Class<?> rawClass) {
        StringProperty p = new StringProperty();
        _addEnumProps(rawClass, p);
        return p.getEnum();
    }

}

package nhenneaux.test.swagger.ext;

import io.swagger.converter.ModelConverters;
import io.swagger.jaxrs.config.BeanConfig;
import nhenneaux.test.swagger.ext.EnumAsModelAwareResolver;

public class EnumModelAwareBeanConfig extends BeanConfig {
    public EnumModelAwareBeanConfig() {
        registerResolver();
    }

    private void registerResolver() {
        ModelConverters modelConverters = ModelConverters.getInstance();
        // remove and add; in case it is called multiple times.
        // should find a better way to register this.
        modelConverters.removeConverter(EnumAsModelAwareResolver.INSTANCE);
        modelConverters.addConverter(EnumAsModelAwareResolver.INSTANCE);
    }

}