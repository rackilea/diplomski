@XmlRootElement
public class RequestXml {
    private Contact[] contact;

    @XmlElement(name = "Contact")
    public Contact[] getContact() {
        return contact;
    }

    public void setContact(Contact[] Contact) {
        this.contact = Contact;
    }
}

public class Contact {
    private String content;
    private String role;

    public Contact(String content, String role) {
        this.content = content;
        this.role = role;
    }

    @XmlValue
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @XmlAttribute
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}