public class Wincall extends Canvas implements Runnable {

public static final int HEIGHT = 640, WIDTH = 1080;

private WinTest w;
// private Handler handler;
private ME me = new ME(this);

public Wincall() {

    // handler = new Handler();
    w = new WinTest(WIDTH, HEIGHT, "Test", this, me);

}

public synchronized void run() {

    while (true) {

        long now = System.currentTimeMillis();

        this.tick();
        this.render();

        long after = System.currentTimeMillis();
        int tt = (int) (after - now);
        if (tt > 5)
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        // System.out.println("Time Taken in millisecs : " + tt);

    }

}

public void tick() {
    // handler.tick();
}

public void render() {

    BufferStrategy bs = this.getBufferStrategy();
    if (bs == null) {
        this.createBufferStrategy(3);
        return;
    }
    Graphics g = bs.getDrawGraphics();

    // render

    g.setColor(Color.BLACK);
    g.fillRect(0, 0, WIDTH, HEIGHT);

    // handler.render(g);

    // render end

    g.dispose();
    bs.show();
}

public void addStuff() {
    System.out.println("addStuff");
    // handler.addObject(new TestGO(me.getX(), me.getY(), 32, 32));

}

public static void main(String[] args) {
    new Wincall();
}
}