import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
private long id;
private String name;
private int age;
public long getId() {
    return id;
}
@XmlAttribute
public void setId(long id) {
    this.id = id;
}
@Override
public String toString() {
    return "Employee [id=" + id + ", name=" + name + ", age=" + age + "]";
}
public String getName() {
    return name;
}
@XmlAnyElement(NameHandler.class)
public void setName(String name) {
    this.name = name;
}
public int getAge() {
    return age;
}
@XmlElement
public void setAge(int age) {
    this.age = age;
}
}