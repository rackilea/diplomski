import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class message {



    public message(){}

    private String to;

    @XmlAttribute 
    public String getTo() {
        return to;
    }



    public void setTo(String to) {
        this.to = to;
    }


    @XmlAttribute 
    public String getFrom() {
        return from;
    }



    public void setFrom(String from) {
        this.from = from;
    }


    @XmlElement  
    public String getBody() {
        return body;
    }



    public void setBody(String body) {
        this.body = body;
    }


    @XmlElement  
    public String getThread() {
        return thread;
    }



    public void setThread(String thread) {this.thread = thread;
    }
private String from;
    private String body;
    private String thread;



    public message(String to, String from, String body,String thread ){  
        super();  
        this.to = to;  
        this.from = from;  
        this.body = body;
        this.thread = thread;

    }  

}