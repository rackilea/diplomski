public void frameSetup(Container parent) {
    // jframe setup code
    parent.setLayout(new BorderLayout());
    parent.add(new JLabel("I'm on top"), BorderLayout.NORTH);
    parent.add(this.dynamicChooser);
    parent.add(new JLabel("I'm on bottom"), BorderLayout.SOUTH);
}