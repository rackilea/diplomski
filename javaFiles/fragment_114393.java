public class BetButtonListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        try {
            int value = Integer.parseInt(text.getText());

            if (value > player.getCurrMon()) {
                label3.setText("You don't have enough money to cover the bet");
            } else {
                String face = "Heads";
                if (e.getSource().equals(tailsBt)) {
                    face = "Tails"
                }
                player.bet(face, value);

                label.setText("Current Money:" + player.getCurrMon());

                if (player.getCurrMon() == 0) {
                    label3.setText("You are out of money");
                    text.setEnabled(false);
                } else if (player.getCurrMon() < 0) {
                    label3.setText("We'll be sending the boys around shortly");
                    text.setEnabled(false);
                }
            }
        } catch (NumberFormatException exp) {
            label3.setText(text.getText() + " is an invalid bet");
        }
        invalidate();
        repaint();
    }

}