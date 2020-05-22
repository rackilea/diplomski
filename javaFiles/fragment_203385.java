setTitle("ThisApp - Best in the business");
setResizable(false);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

setLayout(new GridLayout(2,1));

JButton cat = new JButton("Cat");
this.add(new JButton("Button"));
this.add(new JTextField("CAT CAT",10));     

setSize(300, 200);
setLocationRelativeTo( null );
setVisible(true);