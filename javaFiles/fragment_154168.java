public class Game {

    private void initUI() {
        // ...
        textField.addActionListener(new InputHandler());
        // ...
    }

    // ...

    private void showPlayerNameFrame(int numPlayers) {
        GetPlayerNames playerNameFrame = new GetPlayerNames(numPlayers);
        playerNameFrame.setVisible(true);
    }

    // ...

    private class InputHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String enteredText = e.getActionCommand();
            int numPlayers = Integer.parseInt(enteredText.trim());
            showPlayerNameFrame(numPlayers);
        }
    }
}