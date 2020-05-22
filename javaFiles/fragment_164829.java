import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

    @XmlPath("attr[@name='bookid']/text()")
    private int bookId;

    @XmlPath("attr[@name='bookname']/text()")
    private String bookname;

    @XmlPath("attr[@name='noOfPages']/text()")
    private int noOfPages;

}