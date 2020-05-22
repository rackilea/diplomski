public class AnotherClass {
    private MyFrameWithJTable instance;
    public AnotherClass( MyFrameWithJTable instance ) {
        this.instance = instance;
    }
    public void someMethod( ) {
        instance.doSomeWork( /*supply parameters*/ );
    }
}