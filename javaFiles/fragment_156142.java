public class WindowResizeTest extends JFrame {

    public static void main(String[] args) {
        new WindowResizeTest();
    }

    public WindowResizeTest() {
        this.setSize(640, 480);

        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);
        this.add(panel);

        this.addComponentListener(new ComponentListener() {

            public void componentResized(ComponentEvent e) {
                System.out.println(e.getComponent().getSize());
            }

            public void componentHidden(ComponentEvent e) {}

            public void componentMoved(ComponentEvent e) {}

            public void componentShown(ComponentEvent e) {}
        });

        this.setVisible(true);
    }

}