import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
public class Foo {

    private Character bar;

    @XmlJavaTypeAdapter(CharacterAdapter.class)
    public Character getBar() {
        return bar;
    }

    public void setBar(Character bar) {
        this.bar = bar;
    }

}