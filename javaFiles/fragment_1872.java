import javax.xml.bind.annotation.*;

@XmlRootElement
public class A implements IntF {

    private String foo;

    @Override
    @XmlElement(name="renamed-foo")
    public String getFoo() {
        return foo;
    }

    @Override
    public void setFoo(String foo) {
        this.foo = foo;
    }

}