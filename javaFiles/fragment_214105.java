List<String> ids = respoitory.findAllContact();
ids.forEach(new Consumer<String>() {
  @Override
  public void accept(String s) {
    //use String
  }
});