...
import play.libs.F.*;

public static Promise<Result> index() {
  Promise<Integer> promiseOfInt = Promise.promise(
      new Function0<Integer>() {
        public Integer apply() {
          // long-running operation (will run in separate thread)
          return 42;
        }
      });

  return promiseOfInt.map(
      new Function<Integer, Result>() {
        public Result apply(Integer i) {
          // 'i' is the result after Promise is complete
          return ok("Got result: " + i);
        }
      });
}