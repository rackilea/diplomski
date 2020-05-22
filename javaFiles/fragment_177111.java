BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageData));      
JFrame frame = new JFrame();
frame.setLayout(new FlowLayout());
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.add(new JLabel(new ImageIcon(img)));
frame.pack();
frame.setVisible(true);