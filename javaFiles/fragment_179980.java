public class AAbstract implements A {
    @Override
    public A choice(ChoiceList choices) {
        return this;
    }

    @Override
    public A execute() {
        String variable = Context.get();

        //...

        Context.set("execute");
        return this;
    }
}