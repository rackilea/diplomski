Image image = icon.getImage().getScaledInstance(widthX,heightY, image.SCALE_SMOOTH);            
icon.setImage(image);   

int borderWidth = 1;
int spaceAroundIcon = 0;
Color borderColor = Color.BLUE;

BufferedImage bi = new BufferedImage(icon.getIconWidth() + (2 * borderWidth + 2 * spaceAroundIcon),icon.getIconHeight() + (2 * borderWidth + 2 * spaceAroundIcon), BufferedImage.TYPE_INT_ARGB);

Graphics2D g = bi.createGraphics();
g.setColor(borderColor);
g.drawImage(icon.getImage(), borderWidth + spaceAroundIcon, borderWidth + spaceAroundIcon, null);

BasicStroke stroke = new BasicStroke(5); //5 pixels wide (thickness of the border)
g.setStroke(stroke);

g.drawRect(0, 0, bi.getWidth() - 1, bi.getHeight() - 1);
g.dispose();

label = new JLabel(new ImageIcon(bi), JLabel.LEFT);
label.setVerticalAlignment(SwingConstants.TOP);      

panel.add(label);