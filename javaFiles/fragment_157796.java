public class WorkerThread extends Thread {

    private boolean running = false;

    @Override
    public void run() {
        while (running) {
            // do smth
        }
    }

    @Override
    public void start() {
        setRunning(true);
        super.start();
    }

    @Override
    public void setRunning(boolean value) {
        this.running = running;
    }
}