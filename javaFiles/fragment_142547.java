class MyActivity {
  ...
  private Listener listener = new Listener() {
    @Override
    public onRetryClick() {
      getServer();
    }
  }
}