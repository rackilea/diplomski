public class FooterBar extends JPanel {

    private JLabel label;

    public FooterBar() {

        // Footer test
        setPreferredSize(new Dimension(getWidth(), 16));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        JLabel label;

        label = new JLabel("test");
        label.setHorizontalAlignment(SwingConstants.LEFT);
        add(label);

        label = new JLabel("test 2");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);

    }

}