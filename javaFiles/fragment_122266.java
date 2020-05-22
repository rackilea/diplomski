final TableCellRenderer defaultRenderer = table.getTableHeader().getDefaultRenderer();
        table.getTableHeader().setDefaultRenderer(new TableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table,
                    Object value, boolean isSelected, boolean hasFocus,
                    int row, int column) {
                JLabel label = (JLabel)defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                label.setIcon(null);
                return label;
            }

        });