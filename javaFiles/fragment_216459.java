...
import play.libs.F.*;

public static Result index() {
  Promise<Integer> promiseOfInt = play.libs.Akka.future(
      new Callable<Integer>() {
        public Integer call() {
          // long-running operation (will run in separate thread)
          return 42;
        }
      });
  return async(
      promiseOfInt.map(
        new Function<Integer,Result>() {
          public Result apply(Integer i) {
            // 'i' is the result after Promise is complete
            return ok("Got result: " + i);
          }
        }));
}