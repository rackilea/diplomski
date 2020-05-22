public class main {
    public static void main(String[] args){
        Init init=new Init();
        init.setUp();

        Accessor acc=new Accessor(init);  // pass it in!
        acc.tryAccess();
    }
}