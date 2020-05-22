public void go() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300,300);
    frame.add(this);       //  <-- add this line, 
                           //  you can also use frame.setContentPane(this)
    frame.setVisible(true);
}