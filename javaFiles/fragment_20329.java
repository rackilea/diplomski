private void initializeDialog() {
        dialog = new JDialog() {

            @Override
            public void dispose() {
                KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
                manager.removeKeyEventDispatcher(keyEventDispatcher);
                LOG.info("disposed: " + manager);
                super.dispose();
            }

        };
        WindowListener l = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
                manager.removeKeyEventDispatcher(keyEventDispatcher);
                LOG.info("closing: " + manager);
            }

        };
        dialog.addWindowListener(l);