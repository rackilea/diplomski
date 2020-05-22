class BooleanRenderer extends JCheckBox implements TableCellRenderer, UIResource {

        private static final long serialVersionUID = 1L;
        private final Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);

        BooleanRenderer() {
            super();
            setHorizontalAlignment(JLabel.CENTER);
            setBorderPainted(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                super.setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(table.getBackground());
            }
            setSelected(value != null && ((Boolean) value).booleanValue());
            if (hasFocus) {
                setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
            } else {
                setBorder(noFocusBorder);
            }
            return this;
        }
    }