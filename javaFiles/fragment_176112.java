public class ThingFunction implements Function<Thing, Long> {
    @Override
    public Long apply(Thing thing) {
        return user.getId();
    }
}