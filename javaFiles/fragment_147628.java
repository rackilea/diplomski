@XmlRootElement(name = "Animal",namespace = "http://allmycats.com/serviceplatform/1.0/")
public class Animal2{
    List<Cat2> cats;

    @XmlElement(name = "Cat")
    public List<Cat2> getCats() {
        return cats;
    }

    public void setCats(List<Cat2>cats) {
        this.cats= cats;
    }
}
@XmlRootElement(name = "Cat")
public class Cat2 {
    private String zId;

    @XmlAttribute(name = "Id", namespace="http://schemas.microsoft.com/2003/10/Serialization/")
    public String getzId() {
        return zId;
    }
    public void setzId(String zId) {
        this.zId = zId;
    }

    private String name;

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}