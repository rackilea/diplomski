public class ConsoleAction extends AbstractAction {

    public ConsoleAction() {
        putValue(NAME, "Text of button");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, 0));
        putValue(MNEMONIC_KEY, KeyEvent.VK_A);
    }

    public void actionPerformed(ActionEvent e) {
        gameConsole.append("\n\nCommands: \n ==========");
        commands();
    }
}