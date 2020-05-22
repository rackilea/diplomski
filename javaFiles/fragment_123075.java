public class TheThread extends Thread {
    private final JFrame frame;

    public TheThread(Runnable r, JFrame frame) {
        super(r);
        this.frame = frame;
    }
}