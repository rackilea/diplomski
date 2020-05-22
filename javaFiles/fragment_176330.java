public enum Side {
    LEFT,
    RIGHT
}
//...
Side ToBeRebalanced = FindScapegoat(root, key);  // Find scapegoat node
if (ToBeRebalanced == Side.Left){
  int sizeRoot = TreeSize(root.left, 0);
  root.left = RebuildTree(sizeRoot+1, root.left);
} else {
  int sizeRoot = TreeSize(root.right, 0);
  root.right = RebuildTree(sizeRoot+1, root.right);
}