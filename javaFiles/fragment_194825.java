public class Fizz {

    @Inject    // Guice, new JEE, etc. or
    @Autowired // Spring, or
    private Widget widget;

    public void doSomething() {
        int foo = widget.calculatePremable(this.rippleFactor);
        doSomethingElse(foo);
    }

}