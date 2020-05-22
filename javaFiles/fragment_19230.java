case c: Command =>
  persist(Event(c)) { sender() ! e }

// caller:
import akka.pattern.ask
val f: Future[Event] = (persistentActor ? Command()).mapTo[Event]