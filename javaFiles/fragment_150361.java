public class NodeComparator implements Comparator<Node> {
    public int compare(Node a, Node b) {
        Integer aCount = a.getFunctionCount();
        Integer bCount = b.getFunctionCount();
        return a.compareTo(b);
    }
}