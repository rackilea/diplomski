@Override
public String getToolTipText(MouseEvent event) {
    if (mouseInCorrectRegion(event)) {
        setToolTipText("A tooltip");
    } else {
        setToolTipText(null);
    }
    return super.getToolTipText(event);
}