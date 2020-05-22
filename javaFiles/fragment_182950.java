@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Teacher {

    @XmlAttribute(name="TeacherName")
    String TeacherName;

    @XmlElement(name="StudentName")
    List<String> StudentNames = new ArrayList<String>();

}