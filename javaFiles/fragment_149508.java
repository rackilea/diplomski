ObservableList<Item> data = FXCollections.observableArrayList(new Callback<Item, Observable[]>() {

    @Override
    public Observable[] call(Item param) {
        return new Observable[] { param.keepProperty() };
    }

});
for (int i = 0; i < 10; i++) {
    data.add(new Item(i));
}
FilteredList<Item> filtered = new FilteredList<>(data, Item::isKeep);
filtered.addListener((Observable o) -> System.out.println(filtered));
data.get(3).setKeep(true);
data.get(6).setKeep(true);
data.get(7).setKeep(true);
data.get(3).setKeep(false);