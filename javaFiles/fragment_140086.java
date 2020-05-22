// example code in Scala, but uses Java API

// future executes ASAP
print("Hello ")
Patterns.after(1.second, sys.scheduler, sys.dispatcher, Future { println("World!") })

// future executes after 1 second
print("Hello ")
Patterns.after(1.second, sys.scheduler, sys.dispatcher, 
  new Callable[Future[Unit]] {
    override def call() = Future { println("World!") }
  }
)