scala> import java.util.function.Supplier
import java.util.function.Supplier

scala> val future = CompletableFuture.supplyAsync {
     |   new Supplier[String] {
     |     override def get(): String = {
     |       Thread.sleep(5000) // Wait 5,000 ms (5 seconds).
     |       "We done did it!"
     |     }
     |   }
     | }
future: java.util.concurrent.CompletableFuture[String] = java.util.concurrent.CompletableFuture@35becbd4[Not completed]