class GetSearchedRooms extends Task{

    private final Date date ;

    GetSearchRooms(Date date) {
        this.date = date ;
    }

    @Override
    protected ObservableList<Rooms> call() throws Exception {




        return FXCollections.observableArrayList
                (DataSource.getInstance().showSearchResult(date));
    }

}