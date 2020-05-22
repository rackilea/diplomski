Map<String, Command> commandMap = new HashMap<String, Command>();
commandMap.put("pwd", new Pwd());
commandMap.put("ls", new Ls());

if(commandMap.containsKey(cmd[0])) {
    new Invoker(commandMap.get(cmd[0])).action();
}