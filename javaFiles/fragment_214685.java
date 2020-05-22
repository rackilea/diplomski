public class UserChoice {
    @XmlID 
    @XmlAttribute
    String id;

    @XmlElement(name="availableAction")
    ArrayList<UserAction> actions;
}