Thing th = ofy().transact(new Work<Thing>() {
    public Thing run() {
        Thing thing = ofy().load().key(thingKey).now();
        thing.modify();
        ofy().save().entity(thing);
        return thing;
    }
});