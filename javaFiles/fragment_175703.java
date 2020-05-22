AWTEventListener myListener = new AWTEventListener() {

        @Override
        public void eventDispatched(AWTEvent event) {
            if (event instanceof KeyEvent) {
                ((KeyEvent) event).consume();
            }
        }
    };
    Toolkit.getDefaultToolkit().addAWTEventListener(myListener, AWTEvent.KEY_EVENT_MASK);
    JOptionPane.showMessageDialog(null, "You have a message!");
    Toolkit.getDefaultToolkit().removeAWTEventListener(myListener);