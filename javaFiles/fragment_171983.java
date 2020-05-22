public synchronized void setParent(Body newParent) {
    if (parent != null)
        parent.removeChild(this);
    parent = newParent;
    if (newParent != null)
        newParent.addChild(this);
}