abstract class StrategistAgent<A extends StrategistAgent<A>> implements Agent<A> {
    protected abstract <W extends World> AgentStrategy<A,W> getStrategy();
    protected abstract A getSelf();

    @Override
    public <W extends World> Iterable<Action<A,W>> percepts(W world) {
        return this.<W>getStrategy().run(getSelf(), world);
    }
}