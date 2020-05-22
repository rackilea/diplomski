imageLabel.setLayout(new GridBagLayout());
this.setUndecorated(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setSize(new Dimension(360, 360));
ImageIcon ii = new ImageIcon(this.getClass().getResource("imageexcel.gif"));
imageLabel.setIcon(ii);
add(imageLabel, java.awt.BorderLayout.CENTER);
imageLabel.add(new JButton("START"));
this.setVisible(true);