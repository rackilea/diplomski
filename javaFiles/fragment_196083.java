public static CommandManager fromCommand(String command) {
    for (CommandManager commandManager : values()) {
        if (commandManager.getCommand().equals(command)) {
            return commandManager;
        }
    }
    return null; // or throw exception, whatever fits best for your code
}