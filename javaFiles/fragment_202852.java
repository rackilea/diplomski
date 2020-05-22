JFrame frame = new JFrame("The Lottery");
JPanel mainPanel = new JPanel(new BorderLayout());

JPanel northPanel = new JPanel();
JButton play = new JButton("Play");
JButton exit = new JButton("Exit");
northPanel.add(play);
northPanel.add(exit);
mainPanel.add(northPanel, BorderLayout.NORTH);