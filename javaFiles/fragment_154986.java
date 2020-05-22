public class IsKeyPressed {
    private static boolean wPressed = false;
    public static boolean isWPressed() {
        synchronized (IsKeyPressed.class) {
            return wPressed;
        }
    }
    public static void main(String[] args) {
    KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

        @Override
        public boolean dispatchKeyEvent(KeyEvent ke) {
            synchronized (Test.class) {
                switch (ke.getID()) {
                case KeyEvent.KEY_PRESSED:
                    if (ke.getKeyCode() == KeyEvent.VK_W) {
                        wPressed = true;
                        System.out.println("test");
                    }
                    break;

                case KeyEvent.KEY_RELEASED:
                    if (ke.getKeyCode() == KeyEvent.VK_W) {
                        wPressed = false;
                        System.out.println("test1");
                    }
                    break;
                }
                return false;
            }
        }
    });
   JFrame test = new JFrame();
   test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   test.setVisible(true);
  }
}