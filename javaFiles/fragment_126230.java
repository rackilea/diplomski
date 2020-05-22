DefaultTableModel model = new DefaultTableModel(){
    @Override
    public Class<?> getColumnClass(int col){
        if ( col ==  1 ){
            return Double.class;
        }
        return String.class;
    }
    @Override
    public int getColumnCount(){
        return 2;
    }
};
JTable table = new JTable(model);