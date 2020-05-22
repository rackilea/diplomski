int NUM_SHARDS = 20;

  AggregateEventShards<FriendEvent> TAG =
          AggregateEventTag.sharded(FriendEvent.class, NUM_SHARDS);

  @Override
  default AggregateEventShards<FriendEvent> aggregateTag() {
    return TAG;
  }