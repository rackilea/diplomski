public class AvailableCountry implements Serializable {

@SerializedName("Disabled")
@Expose
private Boolean disabled;
@SerializedName("Selected")
@Expose
private Boolean selected;
@SerializedName("Text")
@Expose
private String text;
@SerializedName("Value")
@Expose
private String value;

public Boolean getDisabled() {
    return disabled;
}

public void setDisabled(Boolean disabled) {
    this.disabled = disabled;
}

public Boolean getSelected() {
    return selected;
}

public void setSelected(Boolean selected) {
    this.selected = selected;
}

public String getText() {
    return text;
}

public void setText(String text) {
    this.text = text;
}

public String getValue() {
    return value;
}

public void setValue(String value) {
    this.value = value;
}