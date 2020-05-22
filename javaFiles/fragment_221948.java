@XmlType(propOrder = {
        "varName",
        "value"
    })
public class Set {

    String varName;
    String value;

    public String getVarName() {
        return varName;
    }

    @XmlAttribute
    public void setVarName(String varName) {
        this.varName = varName;
    }

    public String getValue() {
        return value;
    }

    @XmlAttribute
    public void setValue(String value) {
        this.value = value;
    }
}