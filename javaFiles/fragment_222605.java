import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlRootElement;

public class Test {
    public static void main(String[] args) throws Exception {
        JAXBContext.newInstance(Activity.class);
    }
}
@XmlRootElement
class Activity {
    public String description;
    public int duration;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
}