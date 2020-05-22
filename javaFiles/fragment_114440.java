DefaultTableModel dtm = new DefaultTableModel(data, header){
        @Override
        public Class<?> getColumnClass(int col) {
            if(col == CHECK_BOX_COLUMN_INDEX){
                return Boolean.class;
            }
            return super.getColumnClass(col);
        }
    };