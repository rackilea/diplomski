addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("ispopup?: " + isShowingPopup);
            if (isShowingPopup) {
                showPopup = false;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            showPopup = true;
        }
    });