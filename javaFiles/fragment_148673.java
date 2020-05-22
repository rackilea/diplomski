public static int maximum(NTN t) {
  int max = t.value;
  Set<NTN> children = t.children;

  // only check if this node is not a leaf
  if (children != null && !children.isEmpty) {
    for (NTN e : children) {
      // here is the recursion
      int maxNext = maximum(e);

      if (maxNext > max) max = maxNext;
    }
  }

  return max;
}