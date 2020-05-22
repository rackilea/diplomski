package stackOv;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class TestHandle {
  BiFunction<String, Throwable, String> handle2 = new BiFunction<String, Throwable, String>() {
    @Override
    public String apply(String s, Throwable t) {
      try {
        throw t.getCause(); 
      } catch (Throwable e) {
        // I was hoping to record the custom exceptions here;
        System.out.println(e.toString());
      }
      return s != null ? s : "Hello, Stranger!" + t.toString();
    }
  };

  private void testCompleteExceptionally() {
    String name = "Hearen";
    Supplier<String> supplier2 = () -> {
      delay(500L);
      if (name == null) {
        throw new RuntimeException("Computation error!");
      }
      return "Hello, " + name;
    };
    CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier2);

    if (name != null) {
      // when bad things happen, I try to complete it by exception;
      completableFuture.completeExceptionally(new RuntimeException("Calculation failed!"));      
    }
    System.out.println(completableFuture.handle(handle2).join());
  }

  public static void main(String[] args) {
    TestHandle th = new TestHandle();
    th.testCompleteExceptionally();
  }

  private static void delay(long milli) {
    try { Thread.sleep(milli); } catch (InterruptedException e) {}    
  }
}