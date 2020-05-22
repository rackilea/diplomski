package forum12990635;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "foo", propOrder = {
    "bar"
})
public class Foo {

    @XmlElement(required = true)
    protected String bar;

    public String getBar() {
        return bar;
    }

    public void setBar(String value) {
        this.bar = value;
    }

}