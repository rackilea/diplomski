public void myMethod() {
    final JLabel[] e = {new JLabel("")};
    JButton b = new JButton("ok");
    b.addActionListener(new ActionListener() {
       @Override public void actionPerformed(ActionEvent arg0) {
         e[0].setSize(200,200);
    }});
}