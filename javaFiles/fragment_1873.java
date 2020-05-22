import javax.xml.bind.annotation.*;

@XmlRootElement
public class B implements IntF {

    private String foo;

    @Override
    @XmlAttribute
    public String getFoo() {
        return foo;
    }

    @Override
    public void setFoo(String foo) {
        this.foo = foo;
    }

}