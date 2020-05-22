// in declaration section  
private ImageIcon heartsIcons = new ImageIcon[hearts.length];  

  // in code section
  try {
     for (int i = 0; i < hearts.length; i++) {
        // you may need different code to get the Image file vs. resource.
        BufferedImage img = ImageIO.read(getClass().getResource(hearts[i]));
        heartsIcons[i] = new ImageIcon(img);
     }
  } catch (IOException e) {
     e.printStackTrace();
  }