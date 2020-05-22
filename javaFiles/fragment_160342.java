List<String> acceptedCommands = new ArrayList<>();
acceptedCommands.add("help");
acceptedCommands.add("quit");
// [...]

do { command = ui.getCommand(); }
while (!acceptedCommands.contains(command));