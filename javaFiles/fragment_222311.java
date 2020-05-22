public class BinarySearchTree<…> … {

     protected static class Node { … }

     protected BinarySearchTree.Node createNode() { return new Node(); }
}

public class AVLTree<…> … {
     protected static class Node extends BinarySearchTree.Node { … }

     @Override
     protected AVLTree.Node createNode() { return new AVLTree.Node(); }
}