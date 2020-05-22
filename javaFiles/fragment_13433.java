public void changeTable(JTable table,int column_index) { 
table.getColumnModel().getColumn(column_index).setCellRenderer(new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                final Component c = super.getTableCellRendererComponent(table, value,
                        isSelected, hasFocus, row, column);

                if (!isSelected) {
                    int age = Integer.parseInt(table.getValueAt(row, 1).toString());
     // you can set your own implementation here. As an example I 
     // have checked if the age is over 20 or not. According to the 
     // age return from the table column you get different background colors. 
                    int req_age = 20;
     // in your case req_age can be rs.getString("column_name"); or something
     // you need to check with..
                    if (age < req_age) {
                        c.setBackground(new Color(255, 101, 18));
                    } else {
                        c.setBackground(new Color(0, 204, 0));
                    }

                }
                return c;
            }
        });
    }