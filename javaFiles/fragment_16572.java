public void launchScreen() {
    JFrame frame = new JFrame("Mitternachtsformel");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    //panel erstellen
    JPanel panel = new JPanel();
    panel.setSize(500, 500);
    panel.setBackground(Color.white);

    // Using a grid layout instead of multiple panels
    GridLayout layout = new GridLayout(0,2);
    panel.setLayout(layout);

    JTextField text1 = new JTextField(10);
    JTextField text2 = new JTextField(10);
    JTextField text3 = new JTextField(10);
    JTextField result = new JTextField(10);
    JButton solveButton = new JButton("Solve");
    // Do the calculation when the "Solve" button is pressed
    solveButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try {
                double aZahl = Double.parseDouble(text1.getText());
                double bZahl = Double.parseDouble(text2.getText());
                double cZahl = Double.parseDouble(text3.getText());
                double x1 = (-bZahl + (Math.sqrt((bZahl*bZahl) - 4 * aZahl *cZahl))) / (2*aZahl);
                double x2 = (-bZahl - (Math.sqrt((bZahl*bZahl) - 4 * aZahl *cZahl))) / (2*aZahl);
                result.setText(x1 + ", " + x2);
            }
            catch(Exception ex) {
                result.setText("ERROR: " + ex.getMessage());
            }
        }
    });

    panel.add(new JLabel("Geben sie einen Wert für a an: "));
    panel.add(text1);
    panel.add(new JLabel("Geben sie einen Wert für b an: "));
    panel.add(text2);
    panel.add(new JLabel("Geben sie einen Wert für c an: "));
    panel.add(text3);
    panel.add(solveButton);
    panel.add(result);
    frame.add(panel);
    frame.setVisible(true);
}