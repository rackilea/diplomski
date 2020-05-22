public class CenteringPanel {
    public CenteringPanel(JComponent child) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        GridBagConstraints c = new GridBagConstraints();
        child.setMaximumSize(child.getPreferredSize());
        child.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createVerticalGlue());
        add(child);
        add(Box.createVerticalGlue());
    }
}