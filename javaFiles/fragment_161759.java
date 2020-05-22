private void setChildren(Collection<BoundedArea> children) {
    setSelectedItem(null);
    int oldSize = getSize();
    // Notify the listeners that the all the values have begin removed
    fireIntervalRemoved(this, 0, oldSize - 1);
    this.children.clear();
    for (BoundedArea boundedArea : children) {
        if (boundedArea.getBoundedAreaType() == childType) {
            this.children.add(boundedArea);
        }
    }
    int size = getSize();
    // Notify the listeners that a bunch of new values have begin added...
    fireIntervalAdded(this, 0, size - 1);
}