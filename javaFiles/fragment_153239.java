private int combinationsWithoutCurrent() {
  int num = 1;
  for (ListNode iter = children; iter != null; iter = iter.getNext())
    num *= ((TreeNode)iter.getData()).numStableSets();
  return num;
}

private int combinationsWithCurrent() {
  int num = 1;
  for (ListNode iter = children; iter != null; iter = iter.getNext())
    num *= ((TreeNode)iter.getData()).combinationsWithoutCurrent();
  return num;
}

public int numStableSet() {
  return combinationsWithCurrent() + combinationsWithoutCurrent();
}