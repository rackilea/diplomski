frame.addWindowListener(new WindowAdapter(){
    @Override
    public void windowClosing(WindowEvent e) {
        if(table.isEditing())
            // This will dispose editor and call setValueAt() of your model as normally happens
            table.getCellEditor().stopCellEditing();
    }
});