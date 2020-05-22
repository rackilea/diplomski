menu.addFocusListener(new FocusListener() {
        @Override
        public void focusLost(FocusEvent e) {
            System.out.println("LOST FOCUS");
            isShowingPopup = false;
        }

        @Override
        public void focusGained(FocusEvent e) {
            System.out.println("GAINED FOCUS");
            isShowingPopup = true;
        }
    });