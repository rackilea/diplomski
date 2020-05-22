@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "hello",
    "world"
})
@XmlRootElement(name = "root")
public class Root {

    @XmlElement(required = true)
    protected String hello;
    @XmlElement(required = true)
    protected String world;

    // Getters and Setters
}