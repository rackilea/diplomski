public class KeyBindings {

    private Timer t;

    KeyBindings() {
        t = new Timer();
        long period = 5*60*1000; //For example 0.5 seconds
        long delay = period;
        t.schedule(new TimerTask() {
                @Override
                public void run() {
                   run();
                }
            }, delay, period);
    }

    public static void run() {

        try {

            Keyboard.create();

        } catch (LWJGLException e) {

            e.printStackTrace();
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_F1)) {

            System.out.println(".............................");
        }
   }

}