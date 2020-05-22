BooleanBinding validEntriesBinding = new BooleanBinding(){
    {
        super.bind(listView.getSelectionModel().selectedIndexProperty());
    }
    @Override
    protected boolean computeValue() {
        log.info("No individual item selected? " + 
                (listView.getSelectionModel().getSelectedItems().isEmpty()));
        log.info("Selected items: " + listView.getSelectionModel().getSelectedItems().toString());
        return (listView.getSelectionModel().getSelectedItems().isEmpty());
    }
};