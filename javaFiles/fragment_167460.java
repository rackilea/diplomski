JFrame window = new JFrame();
JPanel mainframe = new JPanel();

window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.setBounds(0,0,200,200);

JButton jb = new JButton();
jb.setText("Leech");

mainframe.add(jb);

JTextField link = new JTextField(50);
mainframe.add(link);

window.getContentPane().add(mainframe);
window.pack();
window.setVisible(true);