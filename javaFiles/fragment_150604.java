public class Person {

    @XmlElement(nillable=true, required=true) //added this
    public Date birthDate;

}