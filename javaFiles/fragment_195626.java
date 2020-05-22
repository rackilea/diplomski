package forum14945664;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Foo {

    private String x;

    public String getXInA() {
        return x;
    }

    public void setXInA(String x) {
        this.x = x;
    }

}