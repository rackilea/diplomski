@XmlAccessorType(XmlAccessType.FIELD)
public class Employee{
    @XmlPath("name[1]/text()")
    private String 

    @XmlPath("name[2]/text()")
    private int age;

    @XmlPath("name[3]/text()")
    private String country;

    //getters and setters
}