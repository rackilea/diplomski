package forum12446506;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Value {

    @XmlAttribute(name="Line")
    Integer line;

    @XmlAttribute
    String type;

    @XmlValue
    String value;

    public Value() {
    }

    public Value(Integer line, String type, String value) {
        this.line = line;
        this.type = type;
        this.value = value;
    }

}