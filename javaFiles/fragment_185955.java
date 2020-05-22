list.setAdapter(new Adapter() {
  public View getView() {
    final Adapter that = this;
    button.setListener(new Listener() {
      public void onClick() {
        that.remove(item);
      }
    );
  }
});