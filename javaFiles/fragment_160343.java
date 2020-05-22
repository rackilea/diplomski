private void echo() {
    String command = null;

    while (!"quit".equals(command)) {
        command = ui.getCommand();
        if (!acceptedCommands.contains(command)) {
            ui.displayString("Please enter a valid command");
        } else if (!"quit".equals(command)) {
           // handle other commands
        }
    }
    ui.displayString("The game is over.");
    // no need for "return;", it's implicit
}