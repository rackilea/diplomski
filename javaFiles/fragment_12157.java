import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Q44234633 {
  public static void main(String[] args) throws InterruptedException {
    Observable.interval(50, TimeUnit.MILLISECONDS)
        .takeWhile(l -> l < 400)
        .observeOn(Schedulers.io())
        .filter(l -> isConditionTrue(l))
        .observeOn(Schedulers.computation())
        .firstElement()
        .doOnSuccess(System.out::println)
        .isEmpty()
        .filter(empty -> empty)
        .doOnSuccess(b -> System.out.println("TimeOut"))
        .blockingGet();
  }

  private static boolean isConditionTrue(long time) {
    return time > ThreadLocalRandom.current().nextInt(5, 20 + 1);
  }
}