@Override
public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
    Component c = super.prepareRenderer(renderer, row, col);
    Object value = getValueAt(row, col);
    if (value instanceof CurrentPrevious) {
        CurrentPrevious curPrev = (CurrentPrevious) value;
        Double current = curPrev.getCurrent();
        Double previous = curPrev.getPrevious();
        Color color = getColor(current, previous);
        c.setBackground(color);
    }
    return c;
}
...
private Color getColor(Double current, Double previous) {
    Color color;
    if (current.equals(previous) || current > previous) {
        color = Color.GREEN;
    } else {
        color = Color.RED;
    }
    return color;
}