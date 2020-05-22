import javax.xml.bind.annotation.*;

@XmlRootElement(name = "WebResponse")
public class WebResponse {

    private Status status;

    @XmlElement(name="Status")
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}