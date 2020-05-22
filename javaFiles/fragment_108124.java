youeTable.setSelectionModel(new DefaultListSelectionModel(){
    @Override
    public void setSelectionInterval(int arg0, int arg1) {
        super.setSelectionInterval(0, t.getRowCount());
    }
});