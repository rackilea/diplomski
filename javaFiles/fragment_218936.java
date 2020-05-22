tm = new DefaultTableModel(data,header){
        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
    };