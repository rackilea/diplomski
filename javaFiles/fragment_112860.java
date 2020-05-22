url = new URL("http://example.gif");
image = ImageIO.read(url);

ImageIcon icon = new ImageIcon(image); 

picture = new JLabel();
picture.setIcon(icon);