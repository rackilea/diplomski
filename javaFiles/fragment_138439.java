public class NewGame {

public static void main(String[] args) {
    JFrame frame = new JFrame("Start up frame");
    JButton newGameButton = new JButton("New Game");
    frame.setLayout(new FlowLayout());
    frame.add(newGameButton);
    frame.setVisible(true);

    newGameButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame newGameWindow = new JFrame("A new game!");
            newGameWindow.setVisible(true);
            newGameWindow.add(new JLabel("Customize your game ui in the new window!"));
            newGameWindow.pack();
        }
    });
    frame.pack();
}
}