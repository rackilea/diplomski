package forum7177628;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    @XmlElement(name="Name")
    private String name;

    @XmlElement(name="Age")
    private int age;

}