try {
    // Execute a command without arguments
    String command = "dir";
    Process child = Runtime.getRuntime().exec(command);

    // Execute a command with an argument
    command = "dir";
    child = Runtime.getRuntime().exec(command);
} catch (IOException e) {
}