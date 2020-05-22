aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  aFrame.setSize(500, 500);
  aFrame.add(cloud);
  //!! aFrame.addMouseListener(new ClickListen());  // !! Removed
  cloud.addMouseListener(new ClickListen());  // !! added
  aFrame.setVisible(true);