private void createConsole() {
    console = new MessageConsole("My Console", null);
    console.activate();
    ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[]{ console });
    MessageConsoleStream stream = console.newMessageStream();

    MyLaunchConfigurationDelegate.setConsole(new PrintStream(stream));
}