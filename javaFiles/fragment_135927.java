JMenuBar menuBar = new JMenuBar();

JMenu file = new JMenu("File");
JMenuItem exitItem = new JMenuItem("Exit");
exitItem.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ev) {
            System.exit(0);
    }
});

JMenu headMenu = new JMenu("Heads");