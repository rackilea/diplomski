import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlType(propOrder={"id", "name", "mailaddress", "password", "servertype", "host", "port", "encryption", "authentication", "interval"})
@XmlAccessorType(XmlAccessType.FIELD)
public class MailAccount {

    private String name;
    private String mailaddress;
    private String password;
    private String servertype;
    private String host;
    private int port;
    private String encryption;
    private boolean authentication;
    private int interval;
    private int id;

}