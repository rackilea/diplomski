for ( int i = 0; i < 4; i++) {
    for ( int j = 0; j < 3; j++) {
        if ( j == 2 && i == 3) {
            label = new JLabel("");
            centerPanel.add(label);
        } else {
            button = new JButton();
            button.addActionListener(this);
            centerPanel.add(button);

            button.setIcon(new ImageIcon(croppedImages.get(0)));
            croppedImages.remove(0);
        }
    }