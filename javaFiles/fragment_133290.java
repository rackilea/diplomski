import akka.actor.{ Actor, DeadLetter, Props }

class Listener extends Actor {
  def receive = {
    case d: DeadLetter => println(d)
  }
}

val listener = system.actorOf(Props(classOf[Listener]))
system.eventStream.subscribe(listener, classOf[DeadLetter])