private Thread blinker;

public void start() {
    blinker = new Thread(this);
    blinker.start();
}

public void stop() {
    blinker.stop();  // UNSAFE!
}

public void run() {
    while (true) {
        try {
            Thread.sleep(interval);
        } catch (InterruptedException e){
        }
        repaint();
    }
}