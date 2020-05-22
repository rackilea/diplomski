static String showQuestion(String dialogTitle, String question, String[] answers) {
    JPanel panel = new JPanel(new BorderLayout());
    panel.add(new JLabel(question), BorderLayout.NORTH);
    JComboBox<String> comboBox = new JComboBox<>(answers);
    panel.add(comboBox);
    if (JOptionPane.CLOSED_OPTION == JOptionPane.showConfirmDialog(null, panel, dialogTitle, JOptionPane.DEFAULT_OPTION)) {
        return null;
    }
    return answers[comboBox.getSelectedIndex()];
}