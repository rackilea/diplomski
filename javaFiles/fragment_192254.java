scala> val scalaFuture = future // Implicit conversion called.
scalaFuture: scala.concurrent.Future[String] = Future(Success(We done did it!))

scala> scalaF.onComplete {
     |   case Success(s) => println(s"Succeeded with '$s'")
     |   case Failure(e) => println(s"Failed with '$e'...")
     | }