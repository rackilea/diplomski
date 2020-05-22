JFrame test = new JFrame();
test.setSize(800,800);
test.setLayout(new GridBagLayout());
test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

GridBagConstraints c;

c = new GridBagConstraints();
c.gridx=0;
c.gridy=0;
c.fill = GridBagConstraints.BOTH;
c.weightx = 1;
c.weighty = 1;
test.add(new JButton("A"), c);

c = new GridBagConstraints();
c.gridx=0;
c.gridy=1;
c.gridwidth=2;
c.fill = GridBagConstraints.BOTH;
c.weightx = 1;
c.weighty = 1;
test.add(new JButton("B"), c);

c = new GridBagConstraints();
c.gridx=1;
c.gridy=0;
c.gridwidth=2;
c.gridheight=1;
c.fill = GridBagConstraints.BOTH;
c.weightx = 2;
c.weighty = 2;
test.add(new JButton("C"), c);

c = new GridBagConstraints();
c.gridx=1;
c.gridy=2;
c.gridwidth=1;
c.gridheight=0;
c.fill = GridBagConstraints.HORIZONTAL;
c.weightx = 1;
c.weighty = 0;
test.add(new JPanel(), c);

c = new GridBagConstraints();
c.gridx=2;
c.gridy=3;
c.gridwidth=1;
c.gridheight=0;
c.fill = GridBagConstraints.HORIZONTAL;
c.weightx = 1;
c.weighty = 0;
test.add(new JPanel(), c);

test.setVisible(true);