public class Reloader implements Runnable {

    private ServletContext context;

    public Reloader(ServletContext context) {
        this.context = context;
    }

    @Override
    public void run() {
        Data data = (Data) context.getAttribute("data");
        if (data != null) {
            data.reload();
        }
    }

}