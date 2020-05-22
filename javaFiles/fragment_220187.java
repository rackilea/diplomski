public void CheckGrid(){
        DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
        int rows = model.getRowCount();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= 10; j++) {
                Object ob = model.getValueAt(i, j);
                if (ob == null || ob.toString().isEmpty()) {
                    model.setValueAt("NA", i, j);
                }
            }
        }
     }