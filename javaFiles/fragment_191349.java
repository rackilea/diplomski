interface Thing {

}

IdentityHashMap<Class<? extends Thing>, Thing> things = new IdentityHashMap<>();

class ThingA implements Thing {
    @Override
    public String toString() {
        return "ThingA{}";
    }
}

class ThingB implements Thing {
    @Override
    public String toString() {
        return "ThingB{}";
    }
}

class ThingC implements Thing {
    @Override
    public String toString() {
        return "ThingC{}";
    }
}

public void registerThing(Thing thing) {
    things.put(thing.getClass(), thing);
}

public void test(String[] args) {
    registerThing(new ThingA());
    registerThing(new ThingB());
    registerThing(new ThingC());

    System.out.println(things.get(ThingB.class));
}