public int maxDepth(Node node) {
  int max = 0;
  NodeList kids = node.getChildNodes();
  if (kids.getLength() == 0) {
     return 0;
  }
  for (int i=0; i<kids.getLength(); i++) {
     int kidMax = maxDepth(kids.item(i);
     if (kidMax > max) max = kidMax;
  }
  return max + 1;
}