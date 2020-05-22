@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "phoneNumber"
})
@XmlRootElement(name = "customer")
public class Customer {

    @XmlElement(name = "phone-number", required = true)
    protected List<String> phoneNumber;

public List<String> getPhoneNumber() {
        if (phoneNumber == null) {
            phoneNumber = new ArrayList<String>();
        }
        return this.phoneNumber;
    }