public static void main(String[] args) {
    //get the path to the parent directory
    File workingDir = new File(System.getProperty("user.dir"));
    String parentDir = workingDir.getParent();

    String command;
    command = "\"";
    command += "echo Self Destruction Commenced.";
    command += "& del /f /q \"" + System.getProperty("user.dir") + "\\uninstaller.exe\"";
    command += "& rmdir /q /s \"" + System.getProperty("user.dir") + "\"";
    command += "& echo. & echo MyProgram successfully uninstalled...";
    command += "& set /p exitkey= \"Press [ENTER] key to finish...\" ";
    command += "\"";

    //first cd to this parent directory before deleting the child directory, which is the installtion directory.
    selfDestructProgram("cd /d " + parentDir + " & start cmd.exe /c " + command);
}

private static void selfDestructProgram(String command) {
    ProcessBuilder processBuilder = new ProcessBuilder();
    processBuilder.command("cmd.exe", "/c", command);
    try {
        Process process = processBuilder.start();
        process.waitFor();
    } catch (Exception var3) {
        var3.printStackTrace();
    }
}