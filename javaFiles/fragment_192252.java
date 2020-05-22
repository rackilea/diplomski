scala> import java.util.function.BiConsumer

scala> future.whenComplete {
     |   new BiConsumer[String, Throwable] {
     |     override def accept(result: String, error: Throwable): Unit = {
     |       println(s"Result was: '$result', error was: '$error'")
     |     }
     |   }
     | }
Result was 'We done did it!'; error was 'null'
res0: java.util.concurrent.CompletableFuture[String] = java.util.concurrent.CompletableFuture@3ea9a091[Completed normally]