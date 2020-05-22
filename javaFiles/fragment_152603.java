package forum12446506;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="EMPLOYEE")
public class Employee {

    @XmlAttribute(name="Line")
    Integer line;

    @XmlAttribute
    String type;

    @XmlElement(name="ID")
    Value id;

    @XmlElement(name="NAME")
    Value name;

    @XmlElement(name="DEPARTMENT")
    Value department;

    @XmlElement(name="SALARY")
    Value salary;

    public Employee() {
    }

    public Employee(int line, String type) {
        this.line = line;
        this.type = type;
    }

}