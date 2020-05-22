public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {

    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    setIcon(getStretchIconFor(value));

    return this;
}

protected StreatchIcon(Object value) {
    StretchIcon icon = null;
    if (!cache.contains(value)) {
        icon = new StretchIcon((Image) value) );
        cache.put(value, icon);
    }
    return icon;
}