public class ActorsModule extends AbstractModule implements AkkaGuiceSupport {

    @Override
    protected void configure() {
        bindActor(SynchronizerParent.class, "parentActor");
        bindActorFactory(Synchronizer.class, Synchronizer.Factory.class);
    }
}