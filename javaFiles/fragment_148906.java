JPanel left = new JPanel(new BorderLayout());
left.add(new TestPane(), BorderLayout.NORTH);
left.add(new TestPane());

JPanel main = new JPanel(new BorderLayout());
main.add(left);
main.add(new TestPane(), BorderLayout.EAST);