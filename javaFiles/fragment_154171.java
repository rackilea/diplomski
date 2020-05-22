public class Game {

    private void initUI() {
        // ...
        textField.addActionListener(this::showPlayerNameFrame);
        // ...
    }

    // ...

    private void showPlayerNameFrame(ActionEvent e) {
        String enteredText = e.getActionCommand();
        int numPlayers = Integer.parseInt(enteredText.trim());
        showPlayerNameFrame(numPlayers);
    }

    private void showPlayerNameFrame(int numPlayers) {
        GetPlayerNames playerNameFrame = new GetPlayerNames(numPlayers);
        playerNameFrame.setVisible(true);
    }

    // ...
}