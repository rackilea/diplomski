public NcgNode getNode(int n) {
  if ((nodeList_ == null) || (n >= nodeList_.size())) {
  return null;
}

return (NcgNode) nodeListSrc_.get(n);
}