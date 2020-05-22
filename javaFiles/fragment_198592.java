private static class InnerEventListener implements SomeEventListener {
    private final WeakReference<ThingToUpdate> thingRef;

    public InnerEventListener(ThingToUpdate thing) {
        thingRef = new WeakReference<>(thing);
    }

    @Override
    public void handleSomeEvent(SomeEvent event) {
        ThingToUpdate thing = thingRef.get();
        if (thing != null) {
            thing.updateSomehow();
        } else {
            ((SomeEventedThing) event.getSource())
                .removeSomeEventListener(this);
        }
    }
}

//...

SomeEventedThing eventedThing;
ThingToUpdate thingToUpdate;

//...

eventedThing.addListener(new InnerEventListener(thingToUpdate));