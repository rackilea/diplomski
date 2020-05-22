import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Foo {

    private boolean bar;

    public boolean isBar() {
        return bar;
    }

    public void setBar(boolean bar) {
        this.bar = bar;
    }

}