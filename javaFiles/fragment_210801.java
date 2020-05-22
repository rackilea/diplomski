import ...
public class CommandPanel extends JPanel {

private JTextField commandResult;
private JButton commandBtn;

public CommandPanel()
{
    this.setLayout( new BorderLayout(10,10));
    this.setBorder( new TitledBorder("Command:") );
    this.setMaximumSize(new Dimension(692,60));
    this.setMinimumSize(new Dimension(692,60));


    commandBtn = new JButton("Execute");
    commandBtn.setMaximumSize(new Dimension(137, 34));
    commandBtn.setMinimumSize(new Dimension(137, 34));
    this.add(commandBtn, BorderLayout.WEST);

    commandResult = new JTextField();
    commandResult.setMaximumSize(new Dimension(518, 34));
    commandResult.setMinimumSize(new Dimension(518, 34));
    this.add(commandResult, BorderLayout.CENTER);
}

public JTextField getCommandResult() {
    return commandResult;
}

public JButton getCommandBtn() {
    return commandBtn;
}

public void setCommandResult(JTextField commandResult) {
    this.commandResult = commandResult;
}

public void setCommandBtn(JButton commandBtn) {
    this.commandBtn = commandBtn;
}
}