public void itemStateChanged(ItemEvent e) {
    if (e.getSource() == bold) {
        if (bold.isSelected()) {

            textField.setFont(new Font("TimesRoman", Font.BOLD, 14));

        } else {

            textField.setFont(new Font("TimesRoman", Font.PLAIN, 14));

        }
    } else if (e.getSource() == itelaic) {
        if (itelaic.isSelected()) {

            textField.setFont(new Font("TimesRoman", Font.ITALIC, 14));

        } else {

            textField.setFont(new Font("TimesRoman", Font.PLAIN, 14));

        }
    }
}