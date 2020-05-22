public LoopControlWindow extends JPanel {
    private Dimension size;

    public LoopControlWindow() {
        Preferences prefs = Preferences.userNodeForPackge("your.java.package");
        size = new Dimension(prefs.getInt("width", 800), prefs.getInt("height", 600));
    }
    public Dimension getPreferredSize() {
        return size;
    }
}