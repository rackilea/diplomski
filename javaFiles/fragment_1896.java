import com.fasterxml.jackson.databind.ObjectMapper

class ScalatraBootstrap extends LifeCycle {

    override def init(context: ServletContext) {

        implicit val objectMapper = new ObjectMapper

        //omitting the rest of the code...
    }
    ...
}