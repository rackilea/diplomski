import com.google.common.base.Optional;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import springfox.documentation.schema.Example;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.EnumTypeDeterminer;
import springfox.documentation.spi.service.contexts.ParameterContext;
import springfox.documentation.spring.web.DescriptionResolver;
import springfox.documentation.swagger.readers.parameter.ApiParamParameterBuilder;

import java.util.function.Predicate;

import static java.util.Optional.ofNullable;
import static springfox.documentation.swagger.common.SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER;
import static springfox.documentation.swagger.common.SwaggerPluginSupport.pluginDoesApply;
import static springfox.documentation.swagger.readers.parameter.Examples.examples;

@Component
public class ShorthandAnnotationPlugin extends ApiParamParameterBuilder {
    private final DescriptionResolver descriptions;
    private final EnumTypeDeterminer enumTypeDeterminer;

    @Autowired
    public ShorthandAnnotationPlugin(
            DescriptionResolver descriptions,
            EnumTypeDeterminer enumTypeDeterminer) {
        super(descriptions, enumTypeDeterminer);
        this.descriptions = descriptions;
        this.enumTypeDeterminer = enumTypeDeterminer;
    }

    @Override
    public void apply(ParameterContext context) {
        Optional<GameIdParam> gameIdParam = context.resolvedMethodParameter().findAnnotation(GameIdParam.class);

        if (gameIdParam.isPresent()) {
            GameIdParam annotation = gameIdParam.get();

            // Instantiate an ApiParam so we can take default values for attributes we didn't override.
            ApiParam parentAnnotation = AnnotationUtils.synthesizeAnnotation(ApiParam.class);

            context.parameterBuilder().name(ofNullable(annotation.name())
                    .filter(((Predicate<String>) String::isEmpty).negate()).orElse(null))
                    .description(ofNullable(descriptions.resolve(annotation.value()))
                            .filter(((Predicate<String>) String::isEmpty).negate()).orElse(null))
                    .parameterAccess(ofNullable(parentAnnotation.access())
                            .filter(((Predicate<String>) String::isEmpty).negate())
                            .orElse(null))
                    .defaultValue(ofNullable(parentAnnotation.defaultValue())
                            .filter(((Predicate<String>) String::isEmpty).negate())
                            .orElse(null))
                    .allowMultiple(parentAnnotation.allowMultiple())
                    .allowEmptyValue(parentAnnotation.allowEmptyValue())
                    .required(parentAnnotation.required())
                    .scalarExample(new Example(parentAnnotation.example()))
                    .complexExamples(examples(parentAnnotation.examples()))
                    .hidden(parentAnnotation.hidden())
                    .collectionFormat(parentAnnotation.collectionFormat())
                    .order(SWAGGER_PLUGIN_ORDER);
        }
    }

    @Override
    public boolean supports(DocumentationType documentationType) {
        return pluginDoesApply(documentationType);
    }
}