private void init() {
    JPanel p = new JPanel();
    p.setLayout(new GridBagLayout());
    for (int i = 0; i < 5; i++) {
        JLabel expLabel = new JLabel(""+i);
        String sExpName = "text"+i;

        p.add(expLabel, getConstraint(new int[] {1, i, 1, 1}));
        JTextField expTextField = new JTextField();
        expTextField.setText(sExpName);
        p.add(expTextField, getConstraint(new int[] {2, i, 1, 1}));
    }
    JPanel dummyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    dummyPanel.add(p);
    add(dummyPanel,BorderLayout.PAGE_START);
}