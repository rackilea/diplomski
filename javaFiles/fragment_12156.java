public boolean showPassword(String pass, int millis) {
    try {
        resetPromptLine("   password>", pass, pass.length());
        Thread.sleep(millis);
        if (setCursorPosition(0) && killLine()) resetPromptLine("   password>", "", 0);

    } catch (InterruptedException | IOException e) {
        e.printStackTrace();
    }
    return false;
}