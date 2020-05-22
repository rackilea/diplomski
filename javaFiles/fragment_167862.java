JLabel l = new JLabel();
        l.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                JLabel clickedLabel = (JLabel) e.getComponent();
            }
        });