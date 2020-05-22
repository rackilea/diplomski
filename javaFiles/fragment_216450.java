frame = new JFrame();
 frame.setBounds(100, 100, 450, 300);
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.getContentPane().setLayout(new MigLayout("", "[grow,right]", "[grow,bottom]"));

 JButton btnNewButton = new JButton("New button");
 frame.getContentPane().add(btnNewButton, "flowx,cell 0 0");

 JButton btnNewButton_1 = new JButton("New button");
 frame.getContentPane().add(btnNewButton_1, "cell 0 0");

 JButton btnNewButton_2 = new JButton("New button");
 frame.getContentPane().add(btnNewButton_2, "cell 0 0");