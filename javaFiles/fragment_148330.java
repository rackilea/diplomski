public class MyAppWindow {
    private final JFrame frame;

    private final JComponent frameContents;

    public MyAppWindow() {
        this.frame = new JFrame("My App");
        this.frameContents = new JPanel();
        // Set up frameContents here...
    }

    public void show() {
        frame.setVisible(true);
    }

    public void hide() {
        frame.setVisible(false);
    }

    public void addField(Component field,
                         String labelText) {

        JLabel label = new JLabel(labelText);
        label.setLabelFor(field);

        // Create layout constraints for label here...

        frameContents.add(label, constraints);

        // Create layout constraints for field here...

        frameContents.add(field, constraints);
    }
}