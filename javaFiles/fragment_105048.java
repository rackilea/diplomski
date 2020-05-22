ImageIcon icon = new ImageIcon("x.gif");
  Image img = icon.getImage();
  Image newimg = img.getScaledInstance(30, 20,
            java.awt.Image.SCALE_SMOOTH);
    icon = new ImageIcon(newimg);
  label = new JLabel(icon);