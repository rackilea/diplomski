public Mdt1()  {
    JFrame blackjack = new JFrame();
    Border wwager = BorderFactory.createTitledBorder("Wager");
    JPanel pwager = new JPanel();
    pwager.setBorder(wwager);
    JLabel lwager = new JLabel("Enter wager:");
 //   JTextField twager = new JTextField(6); //<---  Local variable
    twager = new JTextField(6);              //<--- correction
    twager.addActionListener(this);
    pwager.add(lwager);
    pwager.add(twager);
    ....
}