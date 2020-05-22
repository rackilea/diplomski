/**
 * Read side processor for Dgraph.
 */
public class FriendEventProcessor extends ReadSideProcessor<FriendEvent> {
    private static void createModel() {
        //TODO: Initialize schema in Dgraph
    }

    @Override
    public ReadSideProcessor.ReadSideHandler<FriendEvent> buildHandler() {
        return new ReadSideHandler<FriendEvent>() {
            private final Done doneInstance = Done.getInstance();

            @Override
            public CompletionStage<Done> globalPrepare() {
                createModel();
                return CompletableFuture.completedFuture(doneInstance);
            }

            @Override
            public CompletionStage<Offset> prepare(final AggregateEventTag<FriendEvent> tag) {
                return CompletableFuture.completedFuture(Offset.NONE);
            }

            @Override
            public Flow<Pair<FriendEvent, Offset>, Done, ?> handle() {
                return Flow.<Pair<FriendEvent, Offset>>create()
                        .mapAsync(1, eventAndOffset -> {
                                    if (eventAndOffset.first() instanceof FriendCreated) {
                                        //TODO: Add Friend in Dgraph;
                                    }

                                    return CompletableFuture.completedFuture(doneInstance);
                                }
                        );
            }
        };
    }

    @Override
    public PSequence<AggregateEventTag<FriendEvent>> aggregateTags() {
        return FriendEvent.TAG.allTags();
    }
}