import scala.concurrent.Await
import scala.concurrent.duration._

def index = SecuredAction { implicit request =>
  Await.result(Assets.at("/public", "index.html").apply(request), 5 seconds) //you can specify you maximum wait time here
}