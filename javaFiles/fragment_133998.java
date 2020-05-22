JButton button = new JButton();


  try {
    Image img = ImageIO.read(getClass().getResource("resources/water.bmp"));
    button.setIcon(new ImageIcon(img));
  } catch (IOException ex) {
  }