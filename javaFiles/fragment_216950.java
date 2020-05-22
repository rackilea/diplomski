DefaultTableModel headermodel = new DefaultTableModel(){

    @Override
    public Class<?> getColumnClass(int columnNumber) {
       if (columnNumber == 2 || columnNumber == 3) {
          return Boolean.class;
       } else {
          return super.getColumnClass(columnNumber);
       }
    }
}