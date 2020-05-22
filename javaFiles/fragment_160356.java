@throws(classOf[java.util.concurrent.TimeoutException])
def timedRun[F](timeout: Long)(f: => F): F = {

  import java.util.concurrent.{Callable, FutureTask, TimeUnit}

  val task = new FutureTask(new Callable[F]() {
    def call() = f
  })

  new Thread(task).start() 

  task.get(timeout, TimeUnit.MILLISECONDS)
}