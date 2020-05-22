final int timerDelay = 100;
    final int maxLabelCount = 100; 
    new Timer(timerDelay, new ActionListener() {
        private int labelCount = 0;
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (labelCount < maxLabelCount) {
                final JLabel label = new JLabel("Test");
                // !! label.setSize(160, 40); // NO!
                label.setHorizontalAlignment(SwingConstants.CENTER);
                // Finalise GUI
                window.panel.add(label);
                window.panel.revalidate();
                window.panel.repaint();
            } else {
                // stop this timer
                ((Timer) evt.getSource()).stop();
            }
            labelCount++;
        }
    }).start();