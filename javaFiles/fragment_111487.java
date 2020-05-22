@XmlRootElement(name = "company")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Company {
    private List<Staff> staffList;

    public Company() {
    }

    public Company(List<Staff> staffList) {
        this.staffList = staffList;

    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    @XmlElement(name = "staff")
    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }
}