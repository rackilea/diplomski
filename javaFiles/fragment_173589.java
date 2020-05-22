import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializer;

import javax.xml.namespace.QName;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class XmlMapperApp {

    public static void main(String[] args) throws Exception {
        SimpleModule assetModule = new SimpleModule();
        assetModule.setSerializerModifier(new LoopBackBeanSerializerModifier());

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(assetModule);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.setDefaultUseWrapper(false);

        Assets assets = new Assets();
        assets.getAssets().add(new Asset("x0", "y0"));
        assets.getAssets().add(new Asset("x1", "y1"));

        System.out.println(xmlMapper.writeValueAsString(assets));
    }
}

class LoopBackBeanSerializerModifier extends BeanSerializerModifier {
    @Override
    public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc, JsonSerializer<?> serializer) {
        if (beanDesc.getBeanClass() == Asset.class) {
            return new AssetXMLSerializer(new ExpandXmlBeanSerializer((BeanSerializerBase) serializer));
        }
        return serializer;
    }
}

class ExpandXmlBeanSerializer extends XmlBeanSerializer {

    public ExpandXmlBeanSerializer(BeanSerializerBase src) {
        super(src);
    }

    @Override
    public void serializeFields(Object bean, JsonGenerator gen0, SerializerProvider provider) throws IOException {
        super.serializeFields(bean, gen0, provider);
    }
}

class AssetXMLSerializer extends JsonSerializer<Asset> {

    private final QName wrapper;
    private final ExpandXmlBeanSerializer baseSerializer;

    public AssetXMLSerializer(ExpandXmlBeanSerializer baseSerializer) {
        this.baseSerializer = Objects.requireNonNull(baseSerializer);
        String fields = String.join("_",
                Stream.of(Asset.class.getDeclaredFields())
                .map(Field::getName)
                .collect(Collectors.toList()));
        this.wrapper = new QName(fields);
    }

    @Override
    public void serialize(Asset value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        ToXmlGenerator xmlGen = (ToXmlGenerator) gen;

        xmlGen.writeStartObject();
        xmlGen.startWrappedValue(wrapper, wrapper);
        baseSerializer.serializeFields(value, gen, serializers);
        xmlGen.finishWrappedValue(wrapper, wrapper);
        xmlGen.writeEndObject();

    }
}

@JsonRootName("ASSETS")
class Assets {

    @JacksonXmlProperty(localName = "ASSET")
    private List<Asset> assets = new ArrayList<>();

    // getters, setters, toString
}

class Asset {
    private String val1;
    private String val2;

    public Asset(String val1, String val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    // getters, setters, toString
}