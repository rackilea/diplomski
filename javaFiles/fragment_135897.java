class Controller {

    private static Handler h = new Handler(de);

    static {
        h.start(); // it's guaranteed that the statement is called once
    }

}