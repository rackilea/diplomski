table.setDefaultRenderer(Object.class, new TableCellRenderer(){
    private DefaultTableCellRenderer DEFAULT_RENDERER =  new DefaultTableCellRenderer();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if(isSelected){
                    c.setBackground(Color.YELLOW);
                }else{
                if (row%2 == 0){
                    c.setBackground(Color.WHITE);

                }
                else {
                    c.setBackground(Color.LIGHT_GRAY);
                }     }

       //Add below code here
                return c;
            }

        });