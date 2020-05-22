public void waitForSpace() {
    final CountDownLatch latch = new CountDownLatch(1);
    KeyEventDispatcher dispatcher = new KeyEventDispatcher() {
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_SPACE) {
                latch.countDown();
            }
            return false;
        }
    };
    KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(dispatcher);
    try {
        //current thread waits here until countDown() is called (see a few lines above)
        latch.await(30, TimeUnit.SECONDS);
    } catch (InterruptedException e1) {
        e1.printStackTrace();
    }  
    KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(dispatcher);
}