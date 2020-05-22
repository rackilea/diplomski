try {
    // Execute command
    String command = "cmd /c start cmd.exe";
    Process child = Runtime.getRuntime().exec(command);

    // Get output stream to write from it
    OutputStream out = child.getOutputStream();

    out.write("<execute the java class by mentioning the usual command>");
    out.flush();

    out.close();
} catch (IOException e) {
}