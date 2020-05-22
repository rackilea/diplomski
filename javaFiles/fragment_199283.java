import javax.swing.JFrame;

class JSound extends JFrame {
    //Universal variables are static, and i usually put them here
    public static boolean running = true;
    public static String title = "Advanced Java Sound";
    public static int width = 410;
    public static int height = 600;

    public static int ticks = 1;

    //class setups
    public JSound sound;

    public JSound() {
        //This never gets called for some reason

        //initialises mouse input
        System.out.println("apples");
        setTitle("Simple Frame");
    }

    public static void main(String args[]) {
        System.out.println("I'm before main loop");
        new JSound();
        mainloop();
        System.out.println("I'm after main loop");
        new JSound();
    }

    public static void mainloop() {

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (running) {
            long lastTime = System.nanoTime();
            double amountOfTicks = 60.0;
            double ns = 1000000000 / amountOfTicks;
            double delta = 0;
            long timer = System.currentTimeMillis();
            int frames = 0;
            while (running) {
                long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;
                while (delta >= 1) {
                    ticks++;
                    delta--;
                }
                if (running) {
                    tick();
                }
                frames++;

                if (System.currentTimeMillis() - timer > 1000) {
                    timer += 1000;
                    System.out.println("FPS: " + frames + " Ticks: " + ticks);
                    frames = 0;
                }
            }
        }
    }

    public static void tick() {

    }
}