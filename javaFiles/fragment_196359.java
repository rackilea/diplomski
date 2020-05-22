Pair<ActorRef, Source<ByteString, NotUsed>> source =
  Source.<ByteString>actorRef(256, OverflowStrategy.dropNew())
    .toMat(BroadcastHub.of(ByteString.class), Keep.both())
    .run(materializer);

ActorRef sourceActor = source.first();
Source<ByteString, NotUsed> matSource = source.second();