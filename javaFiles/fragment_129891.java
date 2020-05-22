public class Bar {

    private static final long serialVersionUID = 1L;

    public Bar(final JFrame frame) {
        JMenuBar menuBar = buildMenuBar();
        frame.setJMenuBar(menuBar);

        JPanel masterPanel = new JPanel(new GridLayout(2, 1));

        JPanel pane1 = new JPanel(new GridLayout(3, 1));
        pane1.add(new JLabel("Welcome to the CIT Test Program "));
        pane1.add(new JLabel("Please select which Test Package from the list below."));
        JButton button = new JButton("Click Me");
        pane1.add(button);

        JPanel pane2 = new JPanel(new GridLayout(1, 1));
        String[] tests = { "A+ Certification", "Network+ Certification",
                "Security+ Certification", "CIT Full Test Package" };
        JComboBox packageChoice = new JComboBox(tests);
        pane2.add(packageChoice);

        masterPanel.add(pane1);
        masterPanel.add(pane2);

        frame.add(masterPanel);
        frame.pack();

        frame.setVisible(true);
//      frame.setSize(250, 250);

    }

    public JMenuBar buildMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        JMenuItem newMenu = new JMenuItem("New  (Ctrl+N)");
        JMenuItem openMenu = new JMenuItem("Open  (Ctrl+O)");
        JMenuItem saveMenu = new JMenuItem("Save  (Ctrl+S)");
        saveMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });
        JMenuItem exitMenu = new JMenuItem("Exit  (Ctrl+W)");
        JMenuItem cutMenu = new JMenuItem("Cut  (Ctrl+X)");
        JMenuItem copyMenu = new JMenuItem("Copy  (Ctrl+C)");
        JMenuItem pasteMenu = new JMenuItem("Paste  (Ctrl+V)");
        JMenuItem infoMenu = new JMenuItem("Help  (Ctrl+H)");
        fileMenu.add(newMenu);
        fileMenu.add(openMenu);
        fileMenu.add(saveMenu);
        fileMenu.add(exitMenu);
        editMenu.add(cutMenu);
        editMenu.add(copyMenu);
        editMenu.add(pasteMenu);
        helpMenu.add(infoMenu);
        return menuBar;
    }
}