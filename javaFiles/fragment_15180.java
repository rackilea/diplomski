public class Application extends Controller {

    public static void myAction() {
        commonActionStuff("myAction");
    }

    public static void myAction2() {
        commonActionStuff("myAction2");
    }

    protected static void commonActionStuff(String whoCalledMe) {

        // your common functionality implemented here

        renderText(whoCalledMe);
    }
}