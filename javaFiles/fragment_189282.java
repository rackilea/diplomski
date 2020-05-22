@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "number"
})
@XmlRootElement(name = "customer")
public class Customer {

    @XmlElement(name = "phone-number", required = true)
    protected List<String> number;

public List<String> getNumber() {
        if (number == null) {
            number = new ArrayList<String>();
        }
        return this.number;
    }