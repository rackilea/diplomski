void loopOVerSet(Set cxSet) {
  if (cxSet != null && cxSet.size() > 0) {
    Iterator cxSetIterator = cxSet.iterator();
    while (cxSetIterator.hasNext())
    {
      ((StringProp)cxSetIterator.next()).stringProp();
    }
  }
}