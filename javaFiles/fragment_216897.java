//DEFINE MAIN FRAME
    final JFrame window = new JFrame("Simulator");
    window.setSize(1000, 1000);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLocationRelativeTo(null);

    //DEFINE UNIVERSE PANEL
    JPanel universe = new JPanel();
    universe.setBackground(Color.BLACK);

    //DEFINE UI PANEL
    JPanel ui = new JPanel() {

        @Override
        public Dimension getPreferredSize() {

            return new Dimension(window.getContentPane().getSize().width, window.getContentPane().getSize().height / 4);

        }
    };

    //DEFINE BUTTONS
    JButton femalespawnbutton = new JButton("Spawn Female");
    femalespawnbutton.setSize(250, 100);
    JButton malespawnbutton = new JButton("Spawn Male");
    malespawnbutton.setSize(250, 100);

    //FILL
    ui.add(femalespawnbutton);
    ui.add(malespawnbutton);
    window.add(universe, BorderLayout.CENTER);
    window.add(ui, BorderLayout.SOUTH);
    window.setVisible(true);