@XmlRootElement(name="Person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    @XmlElement
    private String first;
    @XmlElement
    private String last;
    @XmlElement
    private String age;
    public String getFirst() {
        return first;
    }
    public void setFirst(String first) {
        this.first = first;
    }
    public String getLast() {
        return last;
    }
    public void setLast(String last) {
        this.last = last;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person [first=" + first + ", last=" + last + ", age=" + age + "]";
    }
}