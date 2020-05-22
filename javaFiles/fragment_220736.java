// if tree doesn't have root elements
    if(rootNode == null) {
        rootNode = new Node<T>(key,data);
        rootNode.leftChild = null;
        rootNode.rightChild = null;
    }