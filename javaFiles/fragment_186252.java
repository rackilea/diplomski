class CommandFactory {
    // Using spring.
    // This will inject all the classes implementing Command.
    @Autowired
    List<Command> commandList;       

    // Mapping the command name to the implementation  
    Map<String, Command> commandMap;         

    // Initializing the command map
    @PostConstruct
    public void buildMap() {
        for (Command command : commandList) {
            commandMap.put(command.getType(), command);
        }
    }

    public Command getCmd(String cmdType) { 
        return commandMap.get(cmdType);
    }
}