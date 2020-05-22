@XmlRootElement
public class SomeObject {
    private String amount;
    private String id;
    private String someDescription;

    @XmlElement
    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
    @XmlElement
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @XmlElement
    public String getSomeDescription() {
        return someDescription;
    }
    public void setSomeDescription(String someDescription) {
        this.someDescription = someDescription;
    }
}