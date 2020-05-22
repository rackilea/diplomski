public class TrieNode {
    String value;
    // The outgoing (downstream) neighbour nodes
    List<TrieNode> next; // probably LinkedList

    /** Default Constructor with value */
    public TrieNode(String value) {
       this.value = value
    }
}