JButton button = new JButton();
      try {
        Image img = ImageIO.read(getClass().getResource("buttonremorerefresh.png"));
        button.setIcon(new ImageIcon(img));
      } catch (IOException ex) {
      }