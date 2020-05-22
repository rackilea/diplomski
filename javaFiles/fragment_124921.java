@XmlType
public class Data {
    private String fname;
    private String lname;
    private Collection<String> cars;

    // getters
    public String getFname() {
        return fname;
    }
    public String getLname() {
        return lname;
    }
    @XmlElementWrapper(name = "cars")
    @XmlElement(name = "car")
    public String getCars() {
        return cars;
    }


    // setters.....
}