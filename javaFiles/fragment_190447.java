table.getColumnModel().setSelectionModel(new DefaultListSelectionModel() {
    private boolean isSelectable(int index0, int index1) {
        // TODO: Decide if this column index is selectable
        return true;
    }

    @Override
    public void setSelectionInterval(int index0, int index1) {
        if(isSelectable(index0, index1)) {
            super.setSelectionInterval(index0, index1);
        }
    }

    @Override
    public void addSelectionInterval(int index0, int index1) {
        if(isSelectable(index0, index1)) {
            super.addSelectionInterval(index0, index1);
        }
    }
});