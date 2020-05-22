@XmlType(name = "demo")
public class Demo {
    private String valueAttr;
    private String valueContent;

    @XmlAttribute(name = "value")
    public String getValueAttr() {
        return this.valueAttr;
    }

    public void setValueAttr(String valueAttr) {
        this.valueAttr = valueAttr;
    }

    @XmlValue
    public String getValueContent() {
        return this.valueContent;
    }

    public void setValueContent(String valueContent) {
        this.valueContent = valueContent;
    }

}