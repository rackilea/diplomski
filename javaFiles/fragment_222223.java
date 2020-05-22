public abstract class CommandFactory {
    private static Map<String,Command> commands;

    public static Command getInstance(String commandName) {
        if (commands == null) initialize();
        return commands.get(commandName);
    }

    private static void initialize() {
        commands.put("commandA", new CommandA());
        commands.put("commandB", new CommandB());
    }

}