import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Foo {

    @XmlPath("name[@xml:lang='cs']/text()")
    private String csName;

    @XmlPath("name[@xml:lang='en']/text()")
    private String enName;

}