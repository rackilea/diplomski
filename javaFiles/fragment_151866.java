import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name="FOO")
@XmlType(propOrder={"id", "points", "code"})
public class Bar {

    private int id;
    private int points;
    private int code;

    @XmlPath("BAR/id/text()")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlPath("BAR/POINTS/text()")
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @XmlPath("BAR/CODE/text()")
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}