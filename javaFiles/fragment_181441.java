JPanel mainPanel = new JPanel();
  mainPanel.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
        clicks++;
        text.setText(clicks + " Clicks");
     }
  });
  // add mainPanel to the JFrame...