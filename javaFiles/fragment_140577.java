// Required by some API
trait Callable[A] {
  def call(): A
}

trait Processor[A,B] {
  def process(a: A): B
}

// Our helper trait
trait MyImplicits {
  implicit def funToCallable[A](f: () => A) = new Callable[A]() { 
    def call() = f()
  }

  implicit def funToProcessor[A,B](f: (A) => B) = new Processor[A,B]() {
    def process(a: A) = f(a)
  }

}

object App extends MyImplicits {

  def main(args: Array[String]) {
    // Traditional usage
    runSomeCallable(new Callable[String]() {
      def call() = "World"
    })

    runSomeProcessor(new Processor[String,Int] {
      def process(a: String) = a.toInt * 2
    })

    // Usage with implicits
    runSomeCallable(() => "Scala World")

    runSomeProcessor((s: String) => s.toInt * 2)
  }

  // Methods defined by some foreign API
  def runSomeCallable[A](callable: Callable[A]) {
    println("Hello "+callable.call())
  }

  def runSomeProcessor(processor: Processor[String,Int]) {
    println("From 1 to "+processor.process("1"))
  }

}