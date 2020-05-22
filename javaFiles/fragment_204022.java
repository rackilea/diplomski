public class TestFrame extends JFrame {
    JLabel label = new JLabel();

    public TestFrame() {
        super("Resolution tracker");
        setSize(300, 50);
        add(label);
        updateResolution();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                updateResolution();
            }
        });
    }

    protected void updateResolution() {
        DisplayMode mode = this.getGraphicsConfiguration().getDevice().getDisplayMode();
        label.setText(mode.getWidth()+" x "+mode.getHeight());
    }

    public static void main(String args[]) {
        new TestFrame().setVisible(true);
    }
}