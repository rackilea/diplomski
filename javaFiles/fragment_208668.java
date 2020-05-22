Box box = new Box(BoxLayout.Y_AXIS);

JTextArea jTextArea = new JTextArea();

JScrollPane jScrollPane = new JScrollPane(jTextArea);
jScrollPane.getViewport().setPreferredSize(new Dimension(470,500));

JLabel jLabel = new JLabel();

box.add(jScrollPane);
box.add(jLabel);