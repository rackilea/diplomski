TreeNode root = ....;
while (true) {
  TreeNode transformedRoot = reconstruct(root);
  if (root.equals(transformedRoot)) {
    break;
  }
  root = transformedRoot;
}
// root is now in CNF