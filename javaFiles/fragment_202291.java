// Java 8
Platform.runLater(() -> {
    c.updateHebFlow("Script by TulTul", INFO_TEXT);
});

// Java 7
Platform.runLater(new Runnable() {
    public void run() {
        c.updateHebFlow("Script by TulTul", INFO_TEXT);
    }
});