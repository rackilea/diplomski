public class Adapter extends PublicInterface {

    private NeedClass needClass;

    @Override
    public void doSomething() {
        needClass.doSomethingElse("someParameter");
    }
}