if (root == null) 
    return;

      recurse(root.getLeftChild()); 
      int rootData = root.getData();
      recurse(root.getRightChild());