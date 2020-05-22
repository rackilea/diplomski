class CheckBoxRenderer implements TableCellRenderer
{
    JCheckBox   check   = new JCheckBox();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int column)
    {
        if (row != 0 && obj instanceof Boolean)
        {
            check.setSelected((Boolean) obj);
        }
//      return null; this line gives NullPointerException
        return check;
    }
}