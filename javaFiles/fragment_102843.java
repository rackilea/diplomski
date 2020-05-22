addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("isShowingPopup: " + isShowingPopup);
            if (showPopup) {
                Component c = (Component) e.getSource();
                menu.show(c, -1, c.getHeight());
                menu.requestFocus();
            } else {
                showPopup = true;
            }
        }
    });