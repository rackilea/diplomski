public static void setOneRowBackgroundColor(JTable table, int rowIndex,  
            Color color) {  
        try {  
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {  

                public Component getTableCellRendererComponent(JTable table,  
                        Object value, boolean isSelected, boolean hasFocus,  
                        int row, int column) {  
                    if (row == rowIndex) {  
                        setBackground(color);  
                        setForeground(Color.WHITE);  
                    }else if(row > rowIndex){  
                        setBackground(Color.BLACK);  
                        setForeground(Color.WHITE);  
                    }else{  
                        setBackground(Color.BLACK);  
                        setForeground(Color.WHITE);  
                    }  

                    return super.getTableCellRendererComponent(table, value,  
                            isSelected, hasFocus, row, column);  
                }  
            };  
            int columnCount = table.getColumnCount();  
            for (int i = 0; i < columnCount; i++) {  
                table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);  
            }  
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }  
    }