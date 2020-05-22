Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
    @Override
    public void eventDispatched(AWTEvent event) {
        System.out.println(event);
    }
}, AWTEvent.WINDOW_EVENT_MASK);