Timer timer = new Timer(50, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!stop) {
                gamePanel.repaint();
            } else {
                ((Timer)e.getSource()).stop();
            }
        }
    });
    timer.setRepeats(true);
    timer.setDelay(50);
    timer.start();