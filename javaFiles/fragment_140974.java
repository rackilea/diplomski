grid.getStore().addStoreListener(new StoreListener<OptionModel>() {
  public void storeFilter(StoreEvent<OptionModel> se) {
    questionFieldSet.fireEvent(Events.Expand);
    questionFieldSet.fireEvent(Events.Resize);
  }
});