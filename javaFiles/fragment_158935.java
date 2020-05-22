import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class Flow {

    private Node toNode;

    @XmlAttribute
    @XmlJavaTypeAdapter(NodeAdapter.class)
    public Node getToNode() {
        return toNode;
    }

    public void setToNode(Node toNode) {
        this.toNode = toNode;
    }

}