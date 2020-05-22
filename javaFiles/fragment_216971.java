case class RetrieveStateRequest()
case class RetrieveStateResponse[T](actorState: T)

...

class YourActor extends Actor {

  def receive: Receive = {
    case RetrieveStateRequest() => 
         sender() ! RetrieveStateResponse(actorState)
    case m => unhandled(m)
  }
}