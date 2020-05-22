public class SomeThing extends BaseThing {
    public ThingDoer<SomeThing, String> getThingDoer() {
        return Things.getSomeThingDoer();
    }
}

public class SomeOtherThing extends BaseThing {
    public ThingDoer<SomeOtherThing, String> getThingDoer() {
        return Things.getSomeOtherThingDoer();
    }
}