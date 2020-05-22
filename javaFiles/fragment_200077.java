@Override
public void run() {
    int limit = 10;
    try {
        while (limit > 0) {
            limit--;
            repaint();
            Thread.sleep(1000);
        }
    } catch (InterruptedException ex) {
        System.out.println(ex.getMessage());
    }
}