public class NpcChoice {
    @XmlID 
    @XmlAttribute
    String id;

    @XmlElement(name="availableAction")
    ArrayList<NpcAction> actions;
}