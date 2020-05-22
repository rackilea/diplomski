public class MyClient {
    @EJB private MyEJB myEJB;
    public void run() {
        if (myEJB == null)
            CDIUtils.makeManagedStatic(this);
        myEJB.someMethod();
    }
}