public void mainWindow() {

    log.info("enter mainWindow method");

    MigLayout layout = new MigLayout("fillx", "[right]rel[grow,fill]", "[]10[]");
    JPanel panel = new JPanel(layout);

    panel.add(new JLabel("Enter size:"),"");
    panel.add(new JTextField(""),"wrap");
    panel.add(new JLabel("Enter weight:"),"");
    panel.add(new JTextField(""),"");

}