interface Command {
    void execute();
}

interface CommandFactory {
    boolean canCreate(String input);
    Command fromInput(String input); // or return Optional so it can be a FunctionalInterface
}

class TrainCommand implements Command {
    String train;
    public TrainCommand(String t) {  train = t; }
    public void execute() {
        ServiceProvider.getTrainService().saveOrUpdate(t);
    }
}

class TrainCommandFactory {
    public boolean canCreate(String t) {
        return t.contains("new train ");
    }
    public Command fromString(String c) {
        return new TrainCommand(c.replace("new train ", ""));
    }
}