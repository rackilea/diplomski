package forum11966714;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bar {

    private Foo foo;

    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }

}