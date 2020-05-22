public class AssassinNode {

    private final String player;
    private AssassinNode parent;
    private AssassinNode child = null;

    AssassinNode(String player, AssassinNode parent) {
        this.player = player;
        this.parent = parent;
        addToParent(parent);
    }

    void setChild(AssassinNode child) {
        this.child = child;
    }

    private void addToParent(AssassinNode parent) {
        parent.setChild(this);
    }
    // other getters and code
}