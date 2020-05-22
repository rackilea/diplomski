public class GuiceTest {

    public static void main(String[] args) {


        Injector injector = Guice.createInjector(new GuiceTestModule());

        MyApplication appn = injector.getInstance(MyApplication.class);
        appn.sendMessage("msg", "guru");
    }

}