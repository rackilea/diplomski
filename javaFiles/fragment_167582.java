@Override
protected double computePrefWidth(double height, double topInset, double rightInset, double bottomInset, double leftInset) {
    TextField textField = getSkinnable();

    double characterWidth = fontMetrics.get().computeStringWidth("W");

    int columnCount = textField.getPrefColumnCount();

    return columnCount * characterWidth + leftInset + rightInset;
}