Dimension d = new Dimension(350, 400);
GridBagLayout gbl = new GridBagLayout();
JFrame frame = new JFrame("Heloo");
frame.setLayout(gbl);
GridBagConstraints gbc = new GridBagConstraints();

JLabel jl = new JLabel("This is a jlabel!", SwingConstants.CENTER);
jl.setBorder(BorderFactory.createLineBorder(Color.black));
gbc.ipadx = 87;
gbc.ipady = 220;
gbc.insets = new Insets(0, 0, 360, 340);// here work with JFrame size!!