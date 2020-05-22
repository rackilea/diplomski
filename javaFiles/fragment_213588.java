table.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent arg0) {
        int row = table.getSelectedRow();
        if( row < 0 ) return; // check if a row is selected first!
        String getvalue = table.getValueAt(row, table.convertColumnIndexToView( 4 ) ).toString(); // use table.getValueAt, this getter takes view indices! Use convertColumnIndexToView to get a view index from a model index!
        PopulatePhotographerClass pp=new PopulatePhotographerClass(getvalue);
    }
});