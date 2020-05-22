bold.addItemListener(new ItemListener() {
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (bold.isSelected()) {
            textField.setFont(new Font("TimesRoman", Font.BOLD, 14));
        } else {
            textField.setFont(new Font("TimesRoman", Font.PLAIN, 14));
        }
    }
});