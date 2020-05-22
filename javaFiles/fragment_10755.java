private void addComboBox(List<JComboBox> weekdayCombo, JPanel weekdayPanel) {
    ComboBox comboBox1 = createComboBox();
    weekdayCombo.add(comboBox1);
    weekdayPanel.add(comboBox1);
    weekdayPanel.add(Box.createVerticalStrut(STRUT_SIZE));
}