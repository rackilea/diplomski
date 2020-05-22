private class ComboBoxRenderer extends DefaultListCellRenderer {

    private Font baseFont = new JLabel("Test").getFont();

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {

        super.getListCellRendererComponent(list, value, index, isSelected,
                cellHasFocus);
        if (value instanceof Font) {

            Font font = (Font) value;
            setFont(new Font(font.getName(), baseFont.getStyle(), baseFont.getSize())); 
            setText(font.getName());
        }

        return this;
    }
}