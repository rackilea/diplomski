final ActorRef actor =
  Source.actorRef(Integer.MAX_VALUE, OverflowStrategy.fail())
        .to(Sink.foreach(m -> System.out.println(m)))
        .run(materializer);

actor.tell("do something", ActorRef.noSender());