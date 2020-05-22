private BooleanBinding validEntriesBinding ;

// ...

validEntriesBinding = new BooleanBinding(){
    {
        super.bind(listView.getSelectionModel().getSelectedItems());
    }
    @Override
    protected boolean computeValue() {
        log.info("No individual item selected? " + 
                (listView.getSelectionModel().getSelectedItems().isEmpty()));
        log.info("Selected items: " + listView.getSelectionModel().getSelectedItems().toString());
        return (listView.getSelectionModel().getSelectedItems().isEmpty());
    }
};