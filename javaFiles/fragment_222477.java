public class MutipleTreeNode {

static Map<Integer, MyTreeNode<Integer>> nodeMap = new HashMap<>();

public static void main(String[] args) {

    // Here you would process your result set
    // Rather than simulate a result set, I just build some nodes manually
    addNode(0, 1);  // Root
    addNode(1, 2);
    addNode(1, 3);
    addNode(1, 4);
    addNode(2, 5);
    addNode(2, 7);
    addNode(4, 6);

    printTree();

}

private static void printTree() {
    for (MyTreeNode<Integer> node : nodeMap.values()) {
        if (node.getParent() == null)
            System.out.print("Root node: ");
        System.out.println(node.getData()+"; children="+node.getChildren());
    }

}

private static void addNode(int parentId, int childId) {
    MyTreeNode<Integer> childNode, parentNode;
    if (nodeMap.isEmpty())
        childNode = new MyTreeNode<Integer>(childId);
    else {
        parentNode = nodeMap.get(parentId);
        childNode = parentNode.addChild(childId);
    }
    nodeMap.put(childId, childNode);
}

public static class MyTreeNode<T> {
    private T data = null;
    private List<MyTreeNode<T>> children = new ArrayList<MyTreeNode<T>>();
    private MyTreeNode<T> parent = null;

    public MyTreeNode(T data) {
        this.data = data;
    }

    public void addChild(MyTreeNode<T> child) {
        child.setParent(this);
        this.children.add(child);
    }

    public MyTreeNode<T> addChild(T data) {
        MyTreeNode<T> newChild = new MyTreeNode<T>(data);
        newChild.setParent(this);
        children.add(newChild);
        return newChild;
    }

    public void addChildren(List<MyTreeNode<T>> children) {
        for (MyTreeNode<T> t : children) {
            t.setParent(this);
        }
        this.children.addAll(children);
    }

    public List<MyTreeNode<T>> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private void setParent(MyTreeNode<T> parent) {
        this.parent = parent;
    }

    public MyTreeNode<T> getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "[data=" + data + "]";
    }
}
}