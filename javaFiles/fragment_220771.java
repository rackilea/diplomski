import scala.concurrent.duration._
import akka.actor.ActorSystem
import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.model.HttpRequest
import akka.actor.Actor
import akka.http.scaladsl.server.Directives._
import akka.actor.Props
import akka.pattern.ask
import akka.util.Timeout
import scala.util.{Success, Failure}
import akka.http.scaladsl.model.StatusCodes.InternalServerError

class RequestHandlerActor extends Actor {
  override def receive = {
    case httpRequest : HttpRequest =>
      sender() ! HttpResponse(entity = "actor responds nicely")
  }
}

implicit val actorSystem = ActorSystem()
implicit val timeout = Timeout(5 seconds)

val requestRef = actorSystem actorOf Props[RequestHandlerActor]

val route = 
  extractRequest { request =>
    onComplete((requestRef ? request).mapTo[HttpResponse]) {
      case Success(response) => complete(response)
      case Failure(ex) => 
        complete((InternalServerError, s"Actor not playing nice: ${ex.getMessage}"))
    } 
  }