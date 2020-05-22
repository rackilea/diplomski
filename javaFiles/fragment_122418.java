button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (desktop.getAllFrames().length == 0) {
                desktop.add(new MyInternalFrame());

            } else {
                desktop.remove(0);
                desktop.add(new MyInternalFrame());
                revalidate();
                repaint();
            }
        }
    });