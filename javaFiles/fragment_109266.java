public boolean isPreferredSizeSet() {
    return prefSizeSet;
}


/**
 * Gets the preferred size of this component.
 * @return a dimension object indicating this component's preferred size
 * @see #getMinimumSize
 * @see LayoutManager
 */
public Dimension getPreferredSize() {
    return preferredSize();
}


/**
 * @deprecated As of JDK version 1.1,
 * replaced by <code>getPreferredSize()</code>.
 */
@Deprecated
public Dimension preferredSize() {
    /* Avoid grabbing the lock if a reasonable cached size value
     * is available.
     */
    Dimension dim = prefSize;
    if (dim == null || !(isPreferredSizeSet() || isValid())) {
        synchronized (getTreeLock()) {
            prefSize = (peer != null) ?
                peer.getPreferredSize() :
                getMinimumSize();
            dim = prefSize;
        }
    }
    return new Dimension(dim);
}