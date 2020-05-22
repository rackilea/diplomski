if (event.getSource() instanceof JLabel) {
        if (x == 1) {
            ((JLabel)event.getSource()).setIcon(new ImageIcon("zoldgomb.jpg"));
            x = 2;
        } else if (x == 2) {
            ((JLabel)event.getSource()).setIcon(new ImageIcon("sargagomb.jpg"));
            x = 1;
        }
    }