public class FireworksPane extends JPanel {

    private FireworkModel model;

    private static final long serialVersionUID = 1L;

    public FireworksPane(FireworkModel model) {
        this.model = model;
        model.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                repaint();
            }
        });
    }

    public FireworkModel getModel() {
        return model;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = getModel().findx();
        int y = getModel().findy();
        g.drawLine(0, 0, x, y);
    }
}