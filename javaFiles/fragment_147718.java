public class UserServiceImpl implements UserService {
    //...
    private final CurrentPersistenceIdsQuery currentIdsQuery;
    private final Materializer mat;

    @Inject
    public UserServiceImpl(PersistentEntityRegistry registry, ActorSystem system, Materializer mat) {
        //...
        this.mat = mat;
        this.currentIdsQuery =
                PersistenceQuery.get(system)
                    .getReadJournalFor(
                        CassandraReadJournal.class,
                        CassandraReadJournal.Identifier()
                    );
        //...
    }

    //...
    @Override
    public ServiceCall<NotUsed, PSequence<User>> getUsers() {
        // Note this should never make production....
        return req -> currentIdsQuery.currentPersistenceIds()
                .filter(id -> id.startsWith("UserEntity"))
                .mapAsync(4, id ->
                    entityRef(id.substring(10))
                        .ask(UserCommand.GetUser.INSTANCE))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .runWith(Sink.seq(), mat)
                .thenApply(TreePVector::from);
    }
    //...
}