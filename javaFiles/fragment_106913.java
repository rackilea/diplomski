import akka.actor._
import akka.routing._

case class Add()

case class Remove()

class Worker(id: Integer) extends UntypedActor {
  println(s"Made worker $id")

  @throws[Exception](classOf[Exception]) override
  def preStart(): Unit = {
    println(s"Starting $id")
  }

  @throws[Exception](classOf[Exception]) override
  def postStop(): Unit = {
    println(s"Stopping $id")
  }

  @throws[Exception](classOf[Exception])
  override def onReceive(message: Any): Unit = message match {
    case _ => println(s"Message received on actor $id")
  }
}

class Master extends Actor {

  var count = 0

  def makeWorker() = {
    val id = count

    count = count + 1

    context.actorOf(Props(new Worker(id)))
  }

  var activeWorkers = Seq.fill(2) {
    makeWorker()
  }

  var router = Router(RoundRobinRoutingLogic(), activeWorkers.map(r => {
    context watch r
    ActorRefRoutee(r)
  }).toIndexedSeq)

  def receive = {
    case Remove =>
      println("Removing route")

      val head = router.routees.head.asInstanceOf[ActorRefRoutee].ref

      head ! PoisonPill

      context unwatch head

      router = router.removeRoutee(head)

      printRoutes()


    case Add =>
      println("Adding route")

      val worker = makeWorker()

      context watch worker

      router = router.addRoutee(worker)

      printRoutes()


    case w: AnyRef =>

      printRoutes()

      router.route(w, sender())
  }

  def printRoutes(): Unit ={
    val size = router.routees.size

    println(s"Total routes $size")
  }
}

object Main extends App {
  var system = ActorSystem.create("foo")

  var master = system.actorOf(Props[Master])

  master ! "foo"

  master ! Remove

  master ! "foo"

  master ! "bar"

  master ! Add

  master ! "biz"
}