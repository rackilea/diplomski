akka.actor.deployment {
  ... //vader, troopers configuration

  /palpatine/broadcaster {
    router = broadcast-group
    routees.paths = ["/palpatine/vader", "/palpatine/troopers"]
  }
}

class Palpatine extends Actor {
   ... //vader, troopers definitions

   val broadcaster = actorOf(FromConfig.props(), "broadcaster")

   def receive = {
     case p@Process => broadcaster ! p
   }
}