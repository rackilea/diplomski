class Module6Project extends JApplet {
  @Override
  public void init() {
    // Not a new Frame, "this" applet.
    this.setBackground(Color.blue);
    this.getContentPane().setLayout(null);
    // this.setSize(500, 500);

    JTextField first = new JTextField("First name",
        150);
    JTextField second = new JTextField("Last name",
        200);
    JTextField third = new JTextField("DoB", 75);
    JTextField fourth = new JTextField("Address", 350);
    JTextField fifth = new JTextField(
        "Additional comments", 250);
    JButton OK = new JButton("OK");
    JButton Cancel = new JButton("Cancel");
    // add everything to the container (or it won't be visible)
    this.add(first);
    this.add(second);
    this.add(third);
    this.add(fourth);
    this.add(fifth);
    this.add(OK);
    this.add(Cancel);
  }
}