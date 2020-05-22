public static final Border focusedCellBorder = UIManager.getBorder("Table.focusCellHighlightBorder");
public static final Border unfocusedCellBorder = createEmptyBorder();
private static Border createEmptyBorder()
{
    Insets i = focusedCellBorder.getBorderInsets(new JLabel());
    return BorderFactory.createEmptyBorder(i.top, i.left, i.bottom, i.right);
}