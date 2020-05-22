public boolean isCDATA(org.dom4j.Node node) {
  for (org.dom4j.Node n : node.content()) {
    if (org.w3c.dom.Node.CDATA_SECTION_NODE == n.getNodeType()) {
      return true;
    }
  }
  return false;
}