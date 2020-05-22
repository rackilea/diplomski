@XmlRootElement(name="Emp_MNS")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

    private String name = "";

    public String getName() {
        if(name.length() == 0) {
            return null;
        }
        return name;
    }

    public void setName(String name) {
        if(null == name) {
            this.name = "";
        } else {
            this.name = name;
        }
    }