JPanel panel = new JPanel(new GridLayout(0, 2));
panel.add(new JLabel("Name"));
panel.add(new JLabel("Last"));
panel.add(new JTextField("Jason"));
panel.add(new JTextField("Cardanas"));
panel.add(new JLabel("Phone"));
panel.add(new JLabel("Email"));
panel.add(new JTextField("333"));
panel.add(new JTextField("X"));
panel.add(new JLabel("PID"));
panel.add(new JLabel("Donation"));
panel.add(new JTextField("X"));
panel.add(new JTextField("0"));
panel.add(new JLabel("Membership"));
panel.add(new JLabel("Points"));
panel.add(new JTextField("false"));
panel.add(new JTextField("0"));

int result = JOptionPane.showConfirmDialog(null, panel, "Quesion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
switch (result) {
    case JOptionPane.OK_OPTION:
        //...
        break;
    case JOptionPane.CANCEL_OPTION:
        //...
        break;
}