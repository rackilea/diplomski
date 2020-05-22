/** @see http://stackoverflow.com/questions/6072956 */
public class BoxTest2 {

    private static final int WIDE = 480;
    private static final int HIGH = WIDE / 8;
    private static final int ROWS = 5;
    private static final Box center = new Box(BoxLayout.Y_AXIS);

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                center.setOpaque(true);
                center.setBackground(Color.lightGray);
                center.add(Box.createVerticalGlue());
                center.add(new EdgePanel());
                for (int i = 0; i < ROWS; i++) {
                    center.add(new BoxPanel());
                }
                center.add(new EdgePanel());
                center.add(Box.createVerticalGlue());
                f.add(center, BorderLayout.CENTER);
                f.pack();
                f.setVisible(true);
            }
        });
    }

    private static class EdgePanel extends JPanel {

        public EdgePanel() {
            Dimension d = new Dimension(WIDE, 2 * HIGH / 3);
            setPreferredSize(d);
            setBackground(Color.red.darker());
        }
    }

    private static class BoxPanel extends JPanel {

        public BoxPanel() {
            setPreferredSize(new Dimension(WIDE, HIGH));
            setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.red));
            setBackground(Color.darkGray);
        }
    }
}