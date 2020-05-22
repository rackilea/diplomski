Window w = SwingUtilities.windowForComponent(tab);
String title = null;
if (w instanceof JFrame) {
    title = ((JFrame) w).getTitle();
} else if (w instanceof JDialog) {
    title = ((JDialog) w).getTitle();
}