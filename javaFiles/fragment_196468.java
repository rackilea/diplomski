public class Accessor {
    private Init init;

    public Accessor(Init init) {
        this.init = init;  // initialize field
    }

    public void tryAccess(){
        // Init init=new Init();  // *** don't create a new instance!! ***
        init.print();
    }
}