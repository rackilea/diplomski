package fields.builder;

import fields.definition.YourFieldDefinition;
import info.magnolia.ui.form.config.AbstractFieldBuilder;
import info.magnolia.ui.form.config.GenericValidatorBuilder;
import info.magnolia.ui.form.field.transformer.Transformer;
import info.magnolia.ui.form.validator.definition.ConfiguredFieldValidatorDefinition;

public class YourFieldBuilder extends AbstractFieldBuilder {
    private YourFieldDefinition definition = new YourFieldDefinition();

    public YourFieldBuilder(String name) {
        definition().setName(name);
    }

    @Override
    public YourFieldDefinition definition() {
        return definition;
    }

    public YourFieldBuilder setTextValue(String text) {
        definition().setTextValue(text);
        return this;
    }

    // This part is from the LinkFieldBuilder-class
    // Overrides for methods in parent class changing return type to allow method chaining

    @Override
    public YourFieldBuilder label(String label) {
        return (YourFieldBuilder) super.label(label);
    }

    @Override
    public YourFieldBuilder i18nBasename(String i18nBasename) {
        return (YourFieldBuilder) super.i18nBasename(i18nBasename);
    }

    @Override
    public YourFieldBuilder i18n(boolean i18n) {
        return (YourFieldBuilder) super.i18n(i18n);
    }

    @Override
    public YourFieldBuilder i18n() {
        return (YourFieldBuilder) super.i18n();
    }

    @Override
    public YourFieldBuilder description(String description) {
        return (YourFieldBuilder) super.description(description);
    }

    @Override
    public YourFieldBuilder type(String type) {
        return (YourFieldBuilder) super.type(type);
    }

    @Override
    public YourFieldBuilder required(boolean required) {
        return (YourFieldBuilder) super.required(required);
    }

    @Override
    public YourFieldBuilder required() {
        return (YourFieldBuilder) super.required();
    }

    @Override
    public YourFieldBuilder requiredErrorMessage(String requiredErrorMessage) {
        return (YourFieldBuilder) super.requiredErrorMessage(requiredErrorMessage);
    }

    @Override
    public YourFieldBuilder readOnly(boolean readOnly) {
        return (YourFieldBuilder) super.readOnly(readOnly);
    }

    @Override
    public YourFieldBuilder readOnly() {
        return (YourFieldBuilder) super.readOnly();
    }

    @Override
    public YourFieldBuilder defaultValue(String defaultValue) {
        return (YourFieldBuilder) super.defaultValue(defaultValue);
    }

    @Override
    public YourFieldBuilder styleName(String styleName) {
        return (YourFieldBuilder) super.styleName(styleName);
    }

    @Override
    public YourFieldBuilder validator(ConfiguredFieldValidatorDefinition validatorDefinition) {
        return (YourFieldBuilder) super.validator(validatorDefinition);
    }

    @Override
    public YourFieldBuilder validator(GenericValidatorBuilder validatorBuilder) {
        return (YourFieldBuilder) super.validator(validatorBuilder);
    }

    @Override
    public YourFieldBuilder transformerClass(Class<? extends Transformer<?>> transformerClass) {
        return (YourFieldBuilder) super.transformerClass(transformerClass);
    }
}