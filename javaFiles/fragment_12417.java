@XmlSeeAlso({Child1.class, Child2.class})
public abstract class Parent {
    @XmlAttribute(name = "one")
    public String getOne() { 
       return "one";
    }
}