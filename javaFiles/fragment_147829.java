public void buildGUI1() throws NullPointerException {
    setTitle("Hauptmenü");
    setSize(800, 480);
    setLayout(new GridLayout());
    setAlwaysOnTop(false);
    setLocation((Toolkit.getDefaultToolkit().getScreenSize().width) / 4, (Toolkit.getDefaultToolkit().getScreenSize().height) / 4);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    final JButton startclickbt = new JButton("Start Clicker");
    startclickbt.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            dispose();
            if (klick == null) {
                klick = new Clicker();
                add(klick);
                // Add this when you need to add/remove components
                revalidate();
                repaint();
            }

        }
    });

    add(startclickbt);
    // Move to here
    setVisible(true);

}