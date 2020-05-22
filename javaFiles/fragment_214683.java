public class UserAction {
    @XmlID 
    @XmlAttribute
    String id;

    @XmlAttribute String text;
    @XmlIDREF NpcChoice npcChoice;
}