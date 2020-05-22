ActionListener listener; // variable is null here

public ListenerTest() {

    JPanel jPanel = new JPanel();
    JButton jButton = new JButton("Activate!");
    jButton.addActionListener(listener); // variable is still null here!
    // ....
}

public void setListener(ActionListener listener) {
    this.listener = listener;  // this has no effect on the JButton
}