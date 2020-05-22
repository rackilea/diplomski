package forum11666565;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Product extends Model {

    public String title;

    @XmlElement(name = "author")
    public List<String> authors;

}