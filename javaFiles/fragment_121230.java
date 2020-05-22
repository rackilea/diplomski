C:\SomeDir>scala
Welcome to Scala 2.13.1 (OpenJDK 64-Bit Server VM, Java 1.8.0_222).
Type in expressions for evaluation. Or try :help.

scala> class Engage
defined class Engage

scala> class Event
defined class Event

scala> trait ATrait {
     |   val test: Option[String]
     | }
defined trait ATrait

scala> trait BaseSchema[T, P] extends ATrait {
     |   override val test: Option[String] = None
     |   val data: T
     |   val parent: P
     | }
defined trait BaseSchema

scala> class SubClass(override val data: Engage, override val parent: Event) extends BaseSchema[Engage, Event]
defined class SubClass