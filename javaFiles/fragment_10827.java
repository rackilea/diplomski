public static void main(String[] args){
    ThingHolder thingHolder = new ThingHolder();

    // create a new Thing (we'll call it "Thing5"),
    // and point thingHolder.thing at it

    thingHolder.thing = new Thing(5);

    // thingHolder.thing now points to Thing5

    final Thing aFinalReference = thingHolder.thing;

    // aFinalReference now ALSO points to Thing5

    // create a new Thing (we'll call it "Thing6"),
    // and point thingHolder.thing at it

    thingHolder.thing = new Thing(6);

    // thingHolder.thing now points at Thing6 instead of Thing5
    // aFinalReference, however, still points at Thing5
}