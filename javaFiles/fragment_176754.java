context.runElevated(new RemoteCallable() {
    @Override
    public Serializable execute() {
        RunExecutableAction action = new RunExecutableAction();
        action.setExecutable(...);
        action.setWorkingDirectory(...);
        // other configuration
        return action.execute(context);
    }
}, true);