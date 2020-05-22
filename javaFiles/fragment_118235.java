class CommandFactories implements CommandFactory {
    private static final CommandFactories INSTANCE;
    private List<CommandFactory> delegates = Arrays.asList(
        new TrainCommandFactory()
        // others
    };
    public boolean canCreate(String t) {
        return delegates.stream()
            .filter(cf -> cf.canCreate(t))
            .findAny().isPresent();
    }
    public Command fromString(String c) {
        return delegates.stream()
            .filter(cf -> cf.canCreate(t))
            .findAny()
            .map(CommandFactory::fromString);
    }
}