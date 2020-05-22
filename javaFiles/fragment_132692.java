interface BaseThingExt
{
   public void doSomethingElse();
}

class ConcreteImplementation implements BaseThing, BaseThingExt {

    private final BaseThing thingDelegate;
    private final BaseThingExt extDelegate;

    public ConcreteImplementation(BaseThing thing, BaseThingExt ext) {
        this.thingDelegate = thing;
        this.extDelegate = ext;
    }


    @Override
    public void doSomething() {
        thingDelegate.doSomething();
    }

    @Override
    public void doSomethingElse() {
        extDelegate.doSomethingElse();
    }
}