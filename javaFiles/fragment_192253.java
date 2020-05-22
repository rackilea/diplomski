import scala.concurrent.{Future, Promise}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.language.implicitConversion
import scala.util.{Failure, Success}

implicit def completableFutureToFuture[T](cf: CompletableFuture[T]): Future[T] = {
  val p = Promise[T]() // Promise monitoring result of java cf.

  // Handle completion of Java future.
  cf.whenComplete {(result, error) =>

    // If error is not null, then future failed.
    if(error ne null) p.failure(error)

    // Otherwise, it succeeded with result.
    else p.success(result)
  }

  // Return the Scala future associated with the promise.
  p.future
}