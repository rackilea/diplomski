addFocusListener(new FocusListener() {

        @Override
        public void focusGained(FocusEvent e) {

        }

        @Override
        public void focusLost(FocusEvent e) {
            keyboard.mouseLeftWindow();
        }

    });