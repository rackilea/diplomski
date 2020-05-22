class Boot extends WebBoot {
  // create an actor system for application

  val system = ActorSystem("rest-service-example")

  // create and start rest service actor

  val serviceActor = system.actorOf(Props[RestServiceActor], "rest-endpoint")
}