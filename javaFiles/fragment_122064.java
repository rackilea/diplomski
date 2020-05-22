HashMap<String, CommandExecutor> commands = new HashMap<String, CommandExecutor>;

commands.put("firstcommand", new FirstCommand());
commands.put("secondcommand", new SecondCommand());

for (String name : commands.keySet()) {
    getCommand(name).setExecutor(commands.get(name));
}