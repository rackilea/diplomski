public void setOpaque(boolean isOpaque) {
    boolean oldValue = getFlag(IS_OPAQUE);
    setFlag(IS_OPAQUE, isOpaque);
    setFlag(OPAQUE_SET, true);
    firePropertyChange("opaque", oldValue, isOpaque);
}