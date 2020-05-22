for (Node n1 : successors) {
  if (n.fSum() > n1.fSum()) {
    exploreList.remove(n);
    exploreList.add(n1);
  }      
}