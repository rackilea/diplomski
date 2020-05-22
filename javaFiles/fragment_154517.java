public void setConsoleOutput(String s, int i) {
    String type = null;
    switch (i) {
        case 0:
            type = "Info";
            break;
        case 1:
            type = "Error";
            break;
        case 2:
            type = "Exception";
            break;
        default:
            type = "Unknown";
            break;
    }
    String output = "[" + ft.format(System.currentTimeMillis()) + "][" + type + "] " + s + "\n";
    consoleOutput.append(output);
}