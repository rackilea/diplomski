package stackoverflow.test;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test{

  private static volatile boolean flag = true;

  public static void main(String[] args) throws ExecutionException, InterruptedException {

    Callable<Boolean> callableTask = () -> {
      if (flag) {
        System.out.println("Flag is true, returning without executing callable logic !");
        return false;
      }
      System.out.println("Flag is false, executing callable logic !");
      return isFlag();
    };

    Future a = submitAsync(callableTask);
    System.out.println("test " + a.get());
  }

  private static  Future<Boolean> submitAsync(Callable<Boolean> taskToRun) {
    ExecutorService e1 =  Executors.newSingleThreadExecutor(new BasicThreadFactory.Builder().namingPattern("").build());

    return e1.submit(taskToRun);
  }

  private static boolean isFlag() {
    return true;
  }
}