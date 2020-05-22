import javax.xml.bind.annotation.XmlElement;

public class Status {

    private long statusCode;
    private String description;

    @XmlElement(name = "StatusCode")
    public long getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(long statusCode) {
        this.statusCode = statusCode;
    }

    @XmlElement(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}