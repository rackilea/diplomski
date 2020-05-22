Runnable doRun = new Runnable() {

        @Override
        public void run() {
            myComponent.requestFocus();//requestFocusInWindow
            myComponent.grabFocus();
        }
    };
    SwingUtilities.invokeLater(doRun);