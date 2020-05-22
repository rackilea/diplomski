public class ThingAccumulator<A> {
    private final ThingBase<A> myThing;

    private SortedMap<Long, A> myMap;

    public static ThingAccumulator<?> create(Thing thing) {
        return new ThingAccumulator(ThingFactory.getThing(thing));
    }

    protected ThingAccumulator(ThingBase<A> thing) {
        myThing = thing;
        myMap = myThing.getCollectionData();
        myMap.put(System.currentTimeMillis(), myThing.doThing());
    }
}