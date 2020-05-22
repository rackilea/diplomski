abstract class PoliteTask implements Task{

    @Override
    public final void before() {
        System.out.println("Hey");
        doBefore();
    }

    protected abstract void doBefore();
    protected abstract void doAfter();

    @Override
    public abstract void doStuff();


    @Override
    public final void after() {
        System.out.println("Cya");
        doAfter();
    }

}

class ActualStuffTask extends PoliteTask {
    private int fancyNumber;

    @Override
    protected void doBefore() {
        // init some things
        fancyNumber = 42;
    }


    @Override
    public void doStuff() {
        System.out.println("Look, a number: "+fancyNumber);
    }


    @Override
    protected void doAfter() {
        // something else
    }
}