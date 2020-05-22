Map<String, Command> commands = new HashMap<String, Command>();
// Fill it with concrete Command implementations with `x`, `y` and so on as keys.

// Then do:
Command command = commands.get(input);
if (command != null) {
    command.execute();
} else {
    // unknown command.
}