public class MyEJBDelegatingImpl implements MyEJB {
    // Inject: can't remember exact annotation
    private MyEJB myEJBFoo;

    // Inject: can't remember exact annotation
    private MyEJB myEJBBar;

    private getDelegate() {
        if (condition for myEJBFoo) {
            return myEJBFoo;
        } else {
            return myEJBBar;
        }
    }

    ...
    //Now implement MyEJB delegating to getDelegate()
}