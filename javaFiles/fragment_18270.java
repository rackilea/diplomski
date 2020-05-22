@Override public Component getTableCellRendererComponent(JTable table, Object value,
    boolean isSelected, boolean hasFocus, int row, int column)
{
    // [... set component values here ...]
    label.setBorder(hasFocus ? UiUtils.focusedCellBorder : UiUtils.unfocusedCellBorder);
    return label;
}