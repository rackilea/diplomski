final TableCellRenderer tcrOs = myTable.getTableHeader().getDefaultRenderer();
       myTable.getTableHeader().setDefaultRenderer(new TableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, 
                   Object value, boolean isSelected, boolean hasFocus, 
                   int row, int column) {
                JLabel lbl = (JLabel) tcrOs.getTableCellRendererComponent(table, 
                      value, isSelected, hasFocus, row, column);
                lbl.setForeground(AppVariables.textColor);
                lbl.setBorder(BorderFactory.createCompoundBorder(lbl.getBorder(), 
                      BorderFactory.createEmptyBorder(0, 5, 0, 0)));
                lbl.setHorizontalAlignment(SwingConstants.LEFT);
                if (isSelected) {
                    lbl.setForeground(Color.red);
                    lbl.setBackground(Color.lightGray);
                } else {
                    lbl.setForeground(Color.blue);
                    lbl.setBackground(Color.black);
                }
                return lbl;
            }
        });