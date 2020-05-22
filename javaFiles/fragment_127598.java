public class Resize {
    public static void main(String[] args) throws Exception {
        final Image logo = ImageIO.read(new URL("http://cdn.sstatic.net/stackexchange/img/logos/so/so-logo.png"));
        final Dimension dim = new Dimension(logo.getWidth(null), logo.getHeight(null));
        final JFrame frame = new JFrame();
        frame.add(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(logo.getScaledInstance(dim.width, dim.height, 0), 0, 0, this);
            }
        });
        final JSlider xSlider = new JSlider(JSlider.HORIZONTAL, 1, dim.width*3, dim.width);
        final JSlider ySlider = new JSlider(JSlider.VERTICAL, 1, dim.height*3, dim.height);

        ChangeListener cl = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                dim.width = xSlider.getValue();
                dim.height = ySlider.getValue();
                frame.repaint();
            }
        };
        xSlider.addChangeListener(cl);
        ySlider.addChangeListener(cl);

        frame.add(xSlider, "South");
        frame.add(ySlider, "East");

        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.show();        
    }
}