/**
 * Represents a node of a Radix tree {@link RadixTreeImpl}
 * 
 * @author Tahseen Ur Rehman
 * @email tahseen.ur.rehman {at.spam.me.not} gmail.com
 * @param <T>
 */
class RadixTreeNode<T> {
    private String key;

    private List<RadixTreeNode<T>> childern;

    private boolean real;

    private T value;

    /**
     * intailize the fields with default values to avoid null reference checks
     * all over the places
     */
        public RadixTreeNode() {
        key = "";
        childern = new ArrayList<RadixTreeNode<T>>();
        real = false;
    }