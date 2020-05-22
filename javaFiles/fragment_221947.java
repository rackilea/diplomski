public class MyObject {
    String value;
    List<Set> set;

    public MyObject(){
        set = new ArrayList<Set>();
    }

    public List<Set> getSet() {
        return this.set;
    }

    @XmlElement
    public void setSet(List<Set> set) {
        this.set = set;
    }

    public String getValue() {
        return value;
    }

    @XmlAttribute
    public void setValue(String value) {
        this.value = value;
    }
}