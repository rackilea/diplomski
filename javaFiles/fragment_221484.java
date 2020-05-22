import javax.xml.bind.annotation.*;

@XmlRootElement(name="root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Expense {

    private String title;
    private String category;
    private String period;
    private String value;

    public Expense() {
    }

    public Expense(String title, String value, String period, String category) {
        this.title = title;
        this.value = value;
        this.period = period;
        this.category = category;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCategory() {
        return this.category;
    }

    public String getPeriod() {
        return this.period;
    }

    public String getValue() {
        return this.value;
    }

}