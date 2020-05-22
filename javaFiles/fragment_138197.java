public class SomeThing extends BaseThing {
    @Override public void doTheThing() {
        Things.getSomeThingDoer().do(this);
    }
}

public class SomeOtherThing extends BaseThing {
    @Override public void doTheThing() {
        Things.getSomeOtherThingDoer().do(this);
    }
}