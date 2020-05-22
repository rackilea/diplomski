JFrame f = new JFrame("Foobar");
  BufferedImage myImage = null;
  try {
      myImage = ImageIO.read(new File("background.png"));
  } catch (Exception ex) {}

  JPanel p = new ImagePanel(myImage);
  p.setLayout(new BorderLayout());
  int gap = 15;
  p.setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));

  JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // new FlowLayout not needed
  southPanel.setOpaque(false);
  JButton button = new JButton("OK");
  //button.setSize(80, 200);
  button.setPreferredSize(new Dimension(80, 200)); // ?? I don't like this.
  button.setFont(new Font("Arial", 1, 40));

  southPanel.add(button);
  p.add(southPanel, BorderLayout.SOUTH);
  f.add(p);
  f.pack(); // call after everything has been added
  f.setLocationRelativeTo(null); // to center
  f.setVisible(true);