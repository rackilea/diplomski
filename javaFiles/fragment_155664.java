@Override
public void actionPerformed(ActionEvent e) {
    Command cmd = commands.get(e.getActionCommand());
    if (cmd != null) {
        cmd.execute();
    }
}