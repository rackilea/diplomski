package forum17791487.bar;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Root {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String foo) {
        this.value = foo;
    }

}