//frame.getContentPane().add(new LeftPanel(), BorderLayout.CENTER);
JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new LeftPanel(), new ViewPanel());
frame.getContentPane().add(pane);
frame.setVisible(true);
frame.setSize(1000, 700);
//frame.pack();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);