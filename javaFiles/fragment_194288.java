function doSomething(i) {
  (i == 12) && (
    // order should be same
    up(),
    left(),
    stop()
  );

  (i == 304) && (
    // order should be same
    right(),
    up(),
    stop()
  );

  (i == 962) && (
    // order should be same
    down(),
    left(),
    up(),
    stop()
  );
}