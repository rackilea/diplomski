// Set the new model
jTable1.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            // This is where your (new) values go.
            {jTextField1.getText(), jTextField2.getText()}
        },
        new String [] {
            // These are the headers for each column.
            "Project Language", "Project Type"
        }
    ) {
        Class[] types = new Class [] {
            java.lang.String.class, java.lang.String.class
        };
        boolean[] canEdit = new boolean [] {
            // Set these for each column. 
            // If false, the end-user cannot edit the contents
            // If true, the end-user is free to play with the data inside.
            false, false
        };

        @Override
        public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });