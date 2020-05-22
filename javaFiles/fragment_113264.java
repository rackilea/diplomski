public void PrintTreeNames() {

  Queue<TreeNode> queue = new LinkedList<TreeNode>();
  queue.add(this.root);
  TreeNode current;
  while ((current = queue.poll()) != null) {
    PrintTreeNames(current, queue);
  }
}

private void PrintTreeNames(TreeNode n, Queue<TreeNode> queue) {

  System.out.println(n.getData().getName());
  if (n.isDirectory()) {
    for (int i = 0; i < n.getChildren().size(); i++) {
      queue.add(n.getChildren().get(i));
    }
  }
}