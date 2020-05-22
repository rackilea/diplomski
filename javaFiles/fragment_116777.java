AWTEventListener listener = new AWTEventListener() {
        @Override
        public void eventDispatched(AWTEvent event) {
            try {
                if (event instanceof KeyEvent) {
                    KeyEvent evt = (KeyEvent) event;
                    if (evt.getID() == KeyEvent.KEY_PRESSED &&
                            evt.getModifiers() == KeyEvent.CTRL_MASK &&
                            evt.getKeyCode() == KeyEvent.VK_F) {
                        System.out.println("Ctrl+F is pressed!");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
            Toolkit.getDefaultToolkit().addAWTEventListener(listener, AWTEvent.KEY_EVENT_MASK|AWTEvent.ACTION_EVENT_MASK);


}


public static void main(String[] args) {
new JFrame("").setVisible(true);
    Main b = new Main();
    b.start();
}