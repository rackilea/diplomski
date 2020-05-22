public class Value 
{

    @XmlPath("text()")
    private String value;

    @XmlPath("@is_special")
    private String isSpecial;

    public String getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(String isSpecial) {
        this.isSpecial = isSpecial;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}