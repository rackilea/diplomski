img = ImageIO.read(file);
jp_image.add(new JLabel(new ImageIcon(img)));
jp_image.setSize(300, 500);
jf.setPreferredSize(new Dimension(500, 500));// no image appears
jp_image.revalidate();
jp_image.repaint();