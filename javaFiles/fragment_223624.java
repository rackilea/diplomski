TableView<MyType> table = new TableView<MyType>() {
    @Override
    public void sort() {
        super.sort();
        showFetchResultsByPage();
    }
};