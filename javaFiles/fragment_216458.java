public static Promise<Result> index() {
    ActorRef myActor = Akka.system().actorFor("user/my-actor");

    return Promise.wrap(ask(myActor, "hello", 1000)).map(
        new Function<Object, Result>() {
            public Result apply(Object response) {
                return ok(response.toString());
            }
        });
}