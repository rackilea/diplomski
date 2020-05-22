final SingleSelectionModel<PopUpBoxContent> selectionModel = new SingleSelectionModel<PopUpBoxContent>();
cellTable.setSelectionModel(selectionModel);
cellTable.addDomHandler(new DoubleClickHandler() {
    public void onDoubleClick(final DoubleClickEvent event) {
        PopUpBoxContent selected = selectionModel.getSelectedObject();
        if (selected != null) {
            System.out.println("double clicked");
        }
    }
},
DoubleClickEvent.getType());

selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
    public void onSelectionChange(SelectionChangeEvent event) {
        System.out.println("clicked");
    }
});