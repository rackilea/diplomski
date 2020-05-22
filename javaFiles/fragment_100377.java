package fields.definition;

import info.magnolia.ui.form.field.definition.ConfiguredFieldDefinition;

public class YourFieldDefinition extends ConfiguredFieldDefinition {
    String text = "";

    public String getTextValue() {
        return text;
    }

    public void setTextValue(String text) {
        this.text = text;
    }
}