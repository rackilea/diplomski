Observable.just(true)
.subscribe(new Consumer<Boolean> {
  public void accept(Boolean aboolean) {
      String x = null;
      x.getBytes();
  }
}, new Consumer<Throwable> {

  public void accept(Throwable e) {
      e.printStackTrace()
  }
});