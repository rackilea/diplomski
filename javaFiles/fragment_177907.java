@Override
protected void handleControlPropertyChange(String p) {
    super.handleControlPropertyChange(p);
    if ("GRAPHIC".equals(p)) {
        adjustTitleLayout();
    }
}