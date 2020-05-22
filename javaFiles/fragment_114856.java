//If I have understood your question, you want two nodes to swap position in the tree structure
public static swapNode(Node parent, Node child)
{
    Long superId = parent.getParentId();
    child.parentId(superId);
    parent.setParentId(child.getId());
    child.setId(parentId);
    //update children lists of parent and child
    //update parent ids of children lists

    //save changes to database
}

//create tree structure from database. Assumes nodes have been loaded from a database
//table where each row represents a node with a parent id column the root node which has parent id null)
//invoke this with all nodes and null for parentId argument
public static List<Node> createNodeTree(List<Node> allNodes, Long parentId)
{
    List<Node> treeList = new ArrayList<Node>();
    for(Node node : nodes)
    {
        if(parentIdMatches(node, parentId))
        {
            node.setChildren(createNodeTree(allNodes, node.getId()));
            treeList.add(node);
        }
    }
    return treeList;
}

private static boolean parentIdMatches(Node node, Long parentId)
{
    return (parentId != null && parentId.equals(node.getParentId())) 
        || (parentId == null && node.getParentId() == null);
}

//The objects loaded from the database should implement this interface
public interface Node
{
    void setParentId(Long id);
    Long getParentId();
    Long getId();
    List<Node> getChildren();
    void setChildren(List<Node> nodes);
}