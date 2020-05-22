enum Command {
    X("x");

    private String commandString;

    Command(String commandString) {
        this.commandString = commandString;
    }

    public String getCommandString() {
        return commandString;
    }
}

interface Action {
    void process();
}

class ActionX implements Action {

    @Override
    public void process() {
        System.out.println("Processing..");
    }
}

class ActionFactory {
    public Action getAction(Command command) {
        // Check command and return action
        // Switch is the best suitable here
        return action;
    }
}