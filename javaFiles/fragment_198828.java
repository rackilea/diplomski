import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlType(namespace = "http://microsoft.com/wsdl/types/", name = "guid")
public class Guid {
   @XmlValue
   public String guid;
}