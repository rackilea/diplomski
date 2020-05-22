class SomethingThatUsesFileHandlers {
  public <T extends HandlerParams> void doSomething(FileHandler<T> handler,
      T params) {
    handler.downloadFile(params);
  }
}