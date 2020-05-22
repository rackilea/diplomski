public class ActionButtons extends JPanel {
    private JButton calc, reset, exit;
    private JPanel actionButtons;
    PaymentInformation pi;

    public ActionButtons(PaymentInformation pi) {
        this.pi = pi;
        actionButtons = new JPanel(new GridLayout(1, 3, 20, 20));
        calc = new JButton("Calculate");
        reset = new JButton("Reset");
        exit = new JButton("Exit");
        actionButtons.add(calc);
        actionButtons.add(reset);
        actionButtons.add(exit);
        actionButtons.setBorder(BorderFactory.createTitledBorder("Action Buttons"));

        // Add ActionListeners
        calc.addActionListener(new ButtonListener());
        reset.addActionListener(new ButtonListener());
        exit.addActionListener(new ButtonListener());

    }

    public JPanel getGUI() {
        return actionButtons;
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Exit")) {
                System.exit(0);
            }
            if (e.getActionCommand().equals("Reset")) {
                pi.changeValues("0.0");
            }
            if (e.getActionCommand().equals("Calculate")) {
                // TODO DO CALCULATIONS
            }

        }

    }
}