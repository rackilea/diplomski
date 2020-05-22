public class LoadingPane extends JPanel {

    private JLabel label;
    private JProgressBar pb;

    public LoadingPane() {
        setLayout(new GridBagLayout());
        setOpaque(false);

        label = new JLabel("Loading, please wait");
        pb = new JProgressBar();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(label, gbc);
        add(pb, gbc);

        addMouseListener(new MouseAdapter() {
        });
        setFocusable(true);
    }

    public void setProgress(float progress) {
        pb.setValue((int) (progress * 100f));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(new Color(128, 128, 128, 128));
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.dispose();
    }

}