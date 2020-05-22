GridLayoutManager manager = new GridLayoutManager(this, 3);
manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
  @Override
  public int getSpanSize(int position) {
    return (3 - position % 3);
  }
});
recyclerView.setLayoutManager(manager);