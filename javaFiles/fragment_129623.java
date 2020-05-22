private Model() {
    final Object[] data = {this.toString()};
    this.model = new DefaultTableModel(data, 1){

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            System.out.println(data[0]);
            return super.getColumnClass(columnIndex);
        }
    };
    model.addRow(data);
}