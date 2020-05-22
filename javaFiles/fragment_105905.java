private DataView createDataView(List list) {
    return new DataView("listview", new ListDataProvider(list)) {
        public void populateItem(final Item item) {
            final DBUser user = (DBUser) item.getModelObject();
            item.add(new Label("id", String.valueOf(user.getid())));
        }
    };
}