public void invalidateLayout(Container parent) {
    checkParent(parent);
    // invalidateLayout is called from Container.invalidate, which
    // does NOT grab the treelock.  All other methods do.  To make sure
    // there aren't any possible threading problems we grab the tree lock
    // here.
    synchronized(parent.getTreeLock()) {
    [...]