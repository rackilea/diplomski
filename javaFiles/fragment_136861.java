package forum8885011;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Example {

    private static final String PROP1_DEFAULT = "default1";
    private static final String PROP2_DEFAULT = "123";

    @XmlElement(defaultValue=PROP1_DEFAULT)
    String prop1;

    @XmlElement(defaultValue=PROP2_DEFAULT)
    Integer prop2;

    public String getProp1() {
        if(null == prop1) {
            return PROP1_DEFAULT;
        }
        return prop1;
    }

    public void setProp1(String value) {
        if(PROP1_DEFAULT.equals(value)) {
            prop1 = null;
        } else {
            prop1 = value;
        }
    }

    public int getProp2() {
        if(null == prop2) {
            return Integer.valueOf(PROP2_DEFAULT);
        }
        return prop2;
    }

    public void setProp2(int value) {
        if(PROP2_DEFAULT.equals(String.valueOf(value))) {
            prop2 = null;
        } else {
            prop2 = value;
        }
    }

}