File file = new File("image.gif");
    image = ImageIO.read(file);
JFrame frame = new JFrame();
JLabel label = new JLabel(new ImageIcon(image));
frame.getContentPane().add(label, BorderLayout.CENTER);
frame.pack();
frame.setVisible(true);