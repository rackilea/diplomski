// prepare fix issue 1: instantiate the notification support    
private TreeModelSupport support;

public ItemTreeModel(MyNode root) {
    this.root = root;
    support = new TreeModelSupport(this);
    // remove the following: a model never listens to itself
    // this.addTreeModelListener(new MyTreeModelListener());
}

// fix issue 1: accept listener
public void addTreeModelListener(TreeModelListener l) {
    support.addTreeModelListener(l);
}

// fix issue 2: notify the listeners on inserts
public void insertNodeInto(final MyNode newNode, final MyNode selNode,
        final int childCount) {
    selNode.add(childCount, newNode);
    newNode.setLocation(selNode);
    support.fireChildAdded(new TreePath(getPathToRoot(selNode)),
            childCount, newNode);
}

// fix issue 3: pathToRoot as needed in TreePath 
public MyNode[] getPathToRoot(MyNode node) {
    ArrayList<MyNode> itemArrayList = new ArrayList<MyNode>();
    // TODO - Add root node ?
    // yes, certainly - please read the java doc for TreePath
    while ((node != null)) { // && (node != root)) {
        itemArrayList.add(0, node);
        node = node.getLocation();
    }
    return itemArrayList
            .toArray(new MyNode[itemArrayList.size()]);
}