public class TreeNode {
    public TreeNode right = null;
    public TreeNode left = null;
    public final char ch;

    TreeNode(char ch) {
        this.ch = ch;
    }

    @Override
    public String toString() {
        return (right == null && left == null) ? Character.toString(ch) : "(" + left.toString()+ ch + right.toString() + ")";
    }

}