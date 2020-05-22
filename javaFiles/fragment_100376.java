package fields;

import com.vaadin.data.Property;
import com.vaadin.data.util.converter.Converter;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomField;
import com.vaadin.ui.TextField;
import fields.definition.YourFieldDefinition;
import info.magnolia.objectfactory.ComponentProvider;

public class YourField extends CustomField<String> { // String is the type your component will work with
    private final ComponentProvider componentProvider;

    private SliderFieldDefinition definition;
    private TextField textField = new TextField();

public YourField(YourFieldDefinition yourFieldDefinition, ComponentProvider componentProvider) {
        this.definition = yourFieldDefinition;
        this.componentProvider = componentProvider;
        setImmediate(true);
    }

    @Override
    protected Component initContent() {
        if (textField.getValue() == null) {
            textField.setValue(definition.getTextValue());
        }

        textField.setWidth("100%");

        return textField;
    }

    @Override
    public Class<String> getType() { // Again the type your component will work with
        return String.class;
    }

    @Override
    public String getValue() { // Again the type your component will work with
        return textField.getValue();
    }

    @Override
    public void setValue(String newValue) throws ReadOnlyException, Converter.ConversionException { // Again the type your component will work with
        textField.setValue(newValue);
    }

    /**
     * Set propertyDatasource.
     * If the translator is not null, set it as datasource.
     */
    @Override
    @SuppressWarnings("rawtypes")
    public void setPropertyDataSource(Property newDataSource) {
        textField.setPropertyDataSource(newDataSource);
        super.setPropertyDataSource(newDataSource);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public Property getPropertyDataSource() {
        return textField.getPropertyDataSource();
    }
}