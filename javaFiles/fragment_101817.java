Map<Integer, List<Node>> mapOfLinkedList = new HashMap<Integer, LinkedList<Node>>();

void addNode(Node root, int level) {
    List levelList = mapOfLinkedList.get(level);  // get List for current level
    if (levelList == null) {
        levelList = new LinkedList<Node>();
    }
    levelList.add(root);                          // add Node to the current level

    if (root.left != null) {                      // recursive left call
        addNode(root.left, level+1);
    }
    if (root.right != null) {                     // recursive right call
        addNode(root.right, level+1);
    }

    return;
}