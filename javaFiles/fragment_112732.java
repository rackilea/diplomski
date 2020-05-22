public void open(File file) {
    JFrame frame = new JFrame("My App");
    frame.getRootPane().putClientProperty("Window.documentFile", file);
    frame.getRootPane().putClientProperty("Window.documentModified", false);

    // Load file
}