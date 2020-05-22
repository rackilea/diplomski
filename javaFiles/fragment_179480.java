import org.eclipse.persistence.oxm.annotations.XmlCDATA;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name=DialogMessage.ROOTNAME, namespace="...")
public class DialogMessage {

    @XmlTransient
    public static final String ROOTNAME = "dialog";

    @XmlElement(name="content-html", namespace="...")
    @XmlCDATA
    private String contentHTML = null;

    public String getContentHTML() {
        return contentHTML;
    }

    public void setContentHTML(String contentHTML) {
        this.contentHTML = contentHTML;
    }

}