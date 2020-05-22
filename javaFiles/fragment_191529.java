import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "fooContainer")
public class FooContainer {

    @XmlElement
    private final CPlexPoly workaround = null;

    @XmlElements({ 
        @XmlElement(name = "poly", type = Poly.class),
        @XmlElement(name = "cPlexPoly", type = CPlexPoly.class) 
    })
    public List<Foo> container = new LinkedList<>();

}