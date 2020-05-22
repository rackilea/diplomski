/* build up command and launch */
    String command = "";
    String file = "FILE IN HERE";
    if (isLinux()) {
        command = "xdg-open " + file;
    } else if (isWindows()) {
        command = "cmd /C start " + file;
    } else
        return;

    try {
        Runtime.getRuntime().exec(command);
    } catch (Exception ex) {
        ex.printStackTrace();
    }