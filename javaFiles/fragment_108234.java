case class MakeRequest(url: String)
class RequestActor extends Actor {

  //force the actor to run in it's own thread
  self.dispatcher = akka.dispatch.Dispatchers.newThreadBasedDispatcher(self)

  def receive = {
    case MakeRequest(url) => //perform the request
  }
}

val totalRequests = 1000
val url = "http://..."
val totalConections = 4

//create one actor per connection and wrap them in a load balancer
val actors = (0 to totalConnections).map{i => actorOf[RequestActor].start}
val requestBalancer = loadBalancerActor(new CyclicIterator(actors))

//start sending requests
for (i <- 0 to totalRequests) {
  requestBalancer ! MakeRequest(url)
}

//send a poison pill to stop the actors after they've finished all the requests
requestBalancer ! Broadcast(PoisonPill)

//wait for the actors to finish
while (actors.foldLeft(false){ (b, a) => b || !a.isShutdown}) {
  Thread.sleep(300)
}

//stop the load balancer
requestBalancer ! PoisonPill