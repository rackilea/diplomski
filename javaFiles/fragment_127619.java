@Override
public Component getTableCellRendererComponent(JTable table, Object value,
                     boolean isSelected, boolean hasFocus, int row, int column) {
    // value is a percentage e.g. 95%
    final String sValue = value.toString();
    int p = 0;
    int index = sValue.indexOf('%');
    if (index != -1) {
        try {
            p = Integer.parseInt(sValue.substring(0, index));
        }
        catch(NumberFormatException e) {
        }
    }
    // Always set full state:
    setValue(p);
    setString(sValue);
    return this;
}