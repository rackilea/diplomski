public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
    switch (orientation) {
    case SwingConstants.VERTICAL:
        return getRowHeight(); // this is what you need
    case SwingConstants.HORIZONTAL:
        return getColumnWidth();
    default:
        throw new IllegalArgumentException("Invalid orientation: " + orientation);
    }
}