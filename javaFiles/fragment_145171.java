historyTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
    protected void setValue(Object value) {
        if( value instanceof ImageIcon ) {
            setIcon((ImageIcon)value);
            setText("");
        } else {
            setIcon(null);
            super.setValue(value);
        }
    }
});