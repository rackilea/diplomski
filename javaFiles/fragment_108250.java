import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


public class SchemaExtensible
{
    @XmlAnyElement(lax=true)
    private List<Element> otherElements;

    @XmlAnyAttribute
    private Map<QName,Object> otherAttributes;
}