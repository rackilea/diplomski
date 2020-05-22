import java.util.List;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Section {

    @XmlAttribute
    private String name;

    @XmlElementWrapper(name="front_order")
    @XmlElement(name="article_type")
    private List<Article> frontOrderArticles;

    @XmlElementWrapper(name="back_order")
    @XmlElement(name="article_type")
    private List<Article> backOrderArticles;

}