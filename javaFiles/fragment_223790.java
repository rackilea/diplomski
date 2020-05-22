static Single<String> method1() {
  return Single.just("x");
}

static Single<String> method2(String in) {
  return Single.just(in+"y");
}