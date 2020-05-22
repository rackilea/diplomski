public void setAlwaysOnTop(boolean alwaysOnTop) throws UIModificationExcepion {
    frame.setAlwaysOnTop(alwaysOnTop);
    // due to existing bug ... is not updated for all cases
    if (frame.isAlwaysOnTop() != alwaysOnTop) {
        throw new UIModificationException("Unable to change 'always on top' property");
    }
}