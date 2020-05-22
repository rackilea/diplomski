public static Result index() {
  ActorRef myActor = Akka.system().actorFor("user/my-actor");

  return async(
    Akka.asPromise(ask(myActor,"hello", 1000)).map(
      new Function<Object,Result>() {
        public Result apply(Object response) {
          return ok(response.toString());
        }
      }
    )
  );
}