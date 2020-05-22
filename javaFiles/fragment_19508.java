package forum12295028;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Customer {

    private String name;

    private List<PhoneNumber> phoneNumbers = 
        new ArrayList<PhoneNumber>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name="phone-number")
    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

}