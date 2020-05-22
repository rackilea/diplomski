import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Node;

public class XPathFlattener {

    private Node root;

    public XPathFlattener(Node root) {
        this.root = root;
    }

    /**
     * Flattens a XPath tree to a list of nodes, in pre-order traversal.
     */
    public List<Node> flatten() {
        List<Node> nodes = flattenTreeToList(this.root, new ArrayList<Node>());
        return nodes; 
    }

    /**
     * Flattens a XPath tree to a list of Strings, each representing the name
     * of the node, but not its contents. 
     * The list is created using pre-order traversal.
     */
    @Override
    public String toString() {
        List<String> nodesStrings = new ArrayList<>();
        for (Node n:this.flatten()) {
            nodesStrings.add(stringRepresentation(n));
        }
        return StringUtils.join(nodesStrings, ", ");
    }

    /**
     * Recursively flattens a Node tree to a list, in pre-order traversal.
     * @param node
     * @param nodes
     * @return
     */
    private static List<Node> flattenTreeToList(Node node, List<Node> nodes) {
        nodes.add(node);
        for (int i=0; i< node.getChildNodes().getLength(); i++) {
            Node childNode = node.getChildNodes().item(i);
            flattenTreeToList(childNode, nodes);
        }
        return nodes;
    }

    /**
     * A String representation of the node structure, without its contents.
     * @param node
     * @return
     */
    private static String stringRepresentation(Node node) {
        return String.format("[%s, (type %d)]", node.getNodeName(), node.getNodeType());
    }

}