import org.xmlunit.util.Predicate;
import org.w3c.dom.Node;

.withNodeFilter(new Predicate<Node>() {
    public boolean test(Node node) {
        return !node.getNodeName().equals(someName);
    }
})