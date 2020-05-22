ImageIcon[] icons = new ImageIcon[IMAGE_COUNT];
for (int i = 0; i < IMAGE_COUNT; i++) {
  BufferedImage img = ImageIO.read(...); // read in the appropriate image
  // ...... here manipulate the image if desired such as re-size it
  icons[i] = new ImageIcon(img);  // put it into an icon
}