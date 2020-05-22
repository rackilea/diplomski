public class Element2 
{
    @JacksonXmlProperty(isAttribute = true)
    private String ns = "yyy";
    @JacksonXmlText
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}