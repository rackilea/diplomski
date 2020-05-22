JFrame jframe=new JFrame();
jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jframe.setPreferredSize(new Dimension(200,200));
Container content = jframe.getContentPane(); // Get the content pane
content.setLayout(new BorderLayout());
JButton jbutton=new JButton("a");
content.add(jbutton, BorderLayout.WEST);
jframe.pack();
jframe.setVisible(true);