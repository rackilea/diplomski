public JButton createButton(String name, String toolTip) {

    // Create image
    BufferedImage a = null;
    try {
      a = ImageIO.read((InputStream) P2P.class.getResourceAsStream("/image/menu/" + name + ".png"));
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    BufferedImage bi = new BufferedImage(70, 70, BufferedImage.TRANSLUCENT);

    Graphics2D g = (Graphics2D) bi.getGraphics();
g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g.drawImage(a, 0, 0, 70, 70, null);
    g.dispose();   
    // get the cursor for this button
    Cursor cursor =
            Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
    ImageIcon iconRollover = new ImageIcon(bi);
    ImageIcon iconDefault = new ImageIcon(bi);
    ImageIcon iconPressed = new ImageIcon(bi);

    // create the button
    JButton button = new JButton();
    //button.addActionListener(this);
    button.setIgnoreRepaint(true);
    button.setFocusable(false);
    button.setToolTipText(toolTip);
    button.setBorder(null);
    button.setContentAreaFilled(false);
    button.setCursor(cursor);
    button.setIcon(iconDefault);
    button.setRolloverIcon(iconRollover);
    button.setPressedIcon(iconPressed);
    return button;
  }