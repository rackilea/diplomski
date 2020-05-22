Toolkit.getDefaultToolkit().addAWTEventListener(this, ...);

for (AWTEventListener listener : Toolkit.getDefaultToolkit().getAWTEventListeners()) {

    java.awt.event.AWTEventListenerProxy proxy = (java.awt.event.AWTEventListenerProxy) listener;
    if (proxy.getListener().equals(this) {
        // there, we found it.
    }
}