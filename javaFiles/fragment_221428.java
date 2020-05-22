import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "body" })
public class Message
{
    private String body;
    public String getBody() { return body; }
    @XmlAnyElement(BodyDomHandler.class)
    public void setBody(String body) { this.body = body; }
}