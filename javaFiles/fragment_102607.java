public TreeNode clone(){
  try {
    TreeNode node = (TreeNode) super.clone();
    HashMap<Integer, SomeOtherClass> newTrackers = new HashMap<>();
    for (Integer key : trackers.keySet()) {
      newTrackers.put(key, trackers.get(key).clone());
    }
    node.trackers = newTrackers;
    return node;
  } catch (CloneNotSupportedException e) {
    return null;      
  }
}