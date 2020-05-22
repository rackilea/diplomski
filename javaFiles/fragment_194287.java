function doSomething(i) {
  var obj = {};

  obj[12] = function () {
    // order should be same
    up();
    left();
    stop();
  };
  obj[304] = function () {
    // order should be same
    right();
    up();
    stop();
  };
  obj[962] = function () {
    // order should be same
    down();
    left();
    up();
    stop();
  };

  // apparently we can't use any conditional statements
  try {
    obj[i]();
  } catch (e) {}
}