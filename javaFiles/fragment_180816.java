import javax.xml.bind.annotation.*;

@XmlRootElement
public class Foo {

    private String bar;

    @XmlAttribute
    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }

}