public TreeNode clone(){
  try {
    TreeNode node = (TreeNode) super.clone();
    node.trackers = (HashMap<Integer, SomeOtherClass>) trackers.clone();
    return node;
  } catch (CloneNotSupportedException e) {
    return null;      
  }
}