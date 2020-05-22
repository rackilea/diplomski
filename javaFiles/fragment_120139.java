public class Base {
    private boolean called;
    public Base() { // doesn't have to be the c'tor; works elsewhere as well
        called = false;
        init();
        if (!called) {
            // throw an exception
        }
    }
    protected void init() {
        called = true;
        // other stuff
    }
}