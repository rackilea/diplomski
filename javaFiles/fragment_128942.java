//application.conf
akka.actor.deployment {
  /palpatine/vader {
    router = broadcast-pool
    nr-of-instances = 1
  }
  /palpatine/troopers {
    router = broadcast-pool
    nr-of-instances = 10
  }
}

class Palpatine extends Actor {
    import context._

    val troopers = actorOf(FromConfig.props(Props[Trooper], 
"troopers").withSupervisorStrategy(strategy) //`strategy` is strategy for troopers

    val vader = actorOf(FromConfig.props(Props[Vader]), "vader")

    override val supervisorStrategy = OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = 1) //stategy for Palpatine's children (routers itself)

    val strategy = OneForOneStrategy(maxNrOfRetries = 100, withinTimeRange = 1) //stategy for troopers

    def receive = {
         case p@Process => troopers ! p; vader ! p
         case t@Terminted => println(t)
    }
 }