try (TreeWalk treeWalk = new TreeWalk(repository)) {
  treeWalk.reset(treeId);
  while (treeWalk.next()) {
    String path = treeWalk.getPathString();
    // ...
  }
}