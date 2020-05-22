GridLayout layout = new GridLayout(1,2); // Or (2,1), depending on how you want orientation
JPanel pane = new JPanel();
pane.setLayout(layout);
pane.add(leftButton); // Where leftButton is the JButton (or other swing component) on the left
pane.add(rightButton); // Same goes for the right JButton
// Then add your JPanel to the Frame and all that jazz below.