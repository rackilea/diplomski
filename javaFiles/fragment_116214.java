@JsonIgnoreProperties(ignoreUnknown = true)
abstract class DefaultMutableTreeNodeMixIn {

    @JsonCreator
    public DefaultMutableTreeNodeMixIn(@JsonProperty Object userObject) {
    }

    @JsonCreator
    public DefaultMutableTreeNodeMixIn(@JsonProperty Object userObject, @JsonProperty boolean allowsChildren) {
    }

    @JsonProperty("childCount")
    abstract int getChildCount();

    @JsonProperty("depth")
    abstract int getDepth();

    @JsonProperty("firstChild")
    @JsonBackReference
    abstract TreeNode getFirstChild();

    @JsonProperty("firstLeaf")
    @JsonBackReference
    abstract DefaultMutableTreeNode getFirstLeaf();

    @JsonProperty("lastChild")
    @JsonBackReference
    abstract TreeNode getLastChild();

    @JsonProperty("lastLeaf")
    @JsonBackReference
    abstract DefaultMutableTreeNode getLastLeaf();

    @JsonProperty("leafCount")
    abstract int getLeafCount();

    @JsonProperty("level")
    abstract int getLevel();

    @JsonProperty("nextLeaf")
    abstract DefaultMutableTreeNode getNextLeaf();

    @JsonProperty("nextNode")
    abstract DefaultMutableTreeNode getNextNode();

    @JsonProperty("nextSibling")
    abstract DefaultMutableTreeNode getNextSibling();

    @JsonProperty("parent")
    abstract TreeNode getParent();

    @JsonProperty("path")
    @JsonBackReference
    abstract TreeNode[] getPath();

    @JsonProperty("previousLeaf")
    abstract DefaultMutableTreeNode getPreviousLeaf();

    @JsonProperty("previousNode")
    abstract DefaultMutableTreeNode getPreviousNode();

    @JsonProperty("previousSibling")
    abstract DefaultMutableTreeNode getPreviousSibling();

    @JsonProperty("siblingCount")
    abstract int getSiblingCount();

    @JsonProperty("isLeaf")
    abstract boolean isLeaf();

    @JsonProperty("isRoot")
    abstract boolean isRoot();
}