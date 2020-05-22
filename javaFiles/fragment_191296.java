public void init() {

 //Don't instantiate your class here
 JPanel panel1 = new JPanel();
 JPanel panel2 = new JPanel();
 GridLayout gl = new GridLayout(4,4,5,5);


 JButton b1 = new JButton("7");
 JButton b2 = new JButton("8");
 JButton b3 = new JButton("9");
 JButton b4 = new JButton("/");

 JButton b5 = new JButton("4");
 JButton b6 = new JButton("5");
 JButton b7 = new JButton("6");
 JButton b8 = new JButton("*");

 JButton b9 = new JButton("1");
 JButton b10 = new JButton("2");
 JButton b11 = new JButton("3");
 JButton b12 = new JButton("-");

 JButton b13 = new JButton("0");
 JButton b14 = new JButton(".");
 JButton b15 = new JButton("=");
 JButton b16 = new JButton("+");


 panel2.add(b1);
 b1.setBackground(Color.white);
 b1.setFont(new Font("Sans Serif", Font.BOLD, 16));
 panel2.add(b2);
 b2.setBackground(Color.BLACK);
 b2.setFont(new Font("Sans Serif", Font.BOLD, 16));
 b2.setForeground(Color.WHITE);
 panel2.add(b3);
 b3.setBackground(Color.white);
 b3.setFont(new Font("Sans Serif", Font.BOLD, 16));
 panel2.add(b4);
 b4.setBackground(Color.BLACK);
 b4.setFont(new Font("Sans Serif", Font.BOLD, 16));
 b4.setForeground(Color.WHITE);


 panel2.add(b5);
 b5.setBackground(Color.BLACK);
 b5.setFont(new Font("Sans Serif", Font.BOLD, 16));
 panel2.add(b6);
 b5.setForeground(Color.WHITE);
 b6.setBackground(Color.white);
 b6.setFont(new Font("Sans Serif", Font.BOLD, 16));
 panel2.add(b7);
 b7.setBackground(Color.BLACK);
 b7.setFont(new Font("Sans Serif", Font.BOLD, 16));
 panel2.add(b8);
 b7.setForeground(Color.WHITE);
 b8.setBackground(Color.white);
 b8.setFont(new Font("Sans Serif", Font.BOLD, 16));

 panel2.add(b9);
 b9.setBackground(Color.white);
 b9.setFont(new Font("Sans Serif", Font.BOLD, 16));
 panel2.add(b10);
 b10.setBackground(Color.BLACK);
 b10.setFont(new Font("Sans Serif", Font.BOLD, 16));     
 b10.setForeground(Color.WHITE);
 panel2.add(b11);
 b11.setBackground(Color.white);
 b11.setFont(new Font("Sans Serif", Font.BOLD, 16));
 panel2.add(b12);
 b12.setBackground(Color.BLACK);
 b12.setFont(new Font("Sans Serif", Font.BOLD, 16));
 b12.setForeground(Color.WHITE);

 panel2.add(b13);
 b13.setBackground(Color.BLACK);
 b13.setFont(new Font("Sans Serif", Font.BOLD, 16));
 b13.setForeground(Color.WHITE);
 panel2.add(b14);
 b14.setBackground(Color.white);
 b14.setFont(new Font("Sans Serif", Font.BOLD, 16));
 panel2.add(b15);
 b15.setBackground(Color.BLACK);
 b15.setFont(new Font("Sans Serif", Font.BOLD, 16));
 b15.setForeground(Color.WHITE);
 panel2.add(b16);
 b16.setBackground(Color.white);
 b16.setFont(new Font("Sans Serif", Font.BOLD, 16));

 panel1.add(new JTextField(20));
 panel2.setLayout(gl);

 //Replace the c instance with the keyword this
 this.add(panel1,BorderLayout.NORTH);
 this.add(panel2,BorderLayout.CENTER);
 this. setVisible(true);

}