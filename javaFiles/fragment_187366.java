public class ModelCustomAttrRes {
@SerializedName("attribute_code")
@Expose
private String attributeCode;
@SerializedName("value")
@Expose
private Object value;

public String getAttributeCode() {
return attributeCode;
}

public void setAttributeCode(String attributeCode) {
this.attributeCode = attributeCode;
}

public Object getValue() {
return value;
}

public void setValue(Object value) {
this.value = value;
}
}