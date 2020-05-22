public static void main(String[] args) {
    args = new String[] { "--verbose", "push" };
    GitApp app = new GitApp();
    // before picocli 4.0:
    new CommandLine(app).parseWithHandler(new RunAll(), args);
    // from picocli 4.0:
    //new CommandLine(app).setExecutionStrategy(new RunAll()).execute(args);
    System.out.println("#GitApp.main after. verbose: " + (app.verboseMode));
}