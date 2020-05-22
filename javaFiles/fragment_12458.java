public class MoveRectangle extends JPanel {

    private Point rectPosition = new Point();
    public static final int RECT_SIZE = 50;

    public Point getRectPosition() {
        return rectPosition; 
    }

    public void setRectPosition(Point position) {
        this.rectPosition = position;
        repaint();
    }

    public MoveRectangle() {
        InputMap inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "up");
        actionMap.put("up", new MoveAction(this, MoveAction.Direction.UP));
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "down");
        actionMap.put("down", new MoveAction(this, MoveAction.Direction.DOWN));
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "left");
        actionMap.put("left", new MoveAction(this, MoveAction.Direction.LEFT));
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "right");
        actionMap.put("right", new MoveAction(this, MoveAction.Direction.RIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(rectPosition.x, rectPosition.y, RECT_SIZE, RECT_SIZE);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200); 
    }

    static class MoveAction extends AbstractAction {
        public enum Direction{
            LEFT, RIGHT, UP, DOWN
        };

        private Direction direction;
        private MoveRectangle panel;

        public MoveAction(MoveRectangle panel, Direction direction) {
            this.direction = direction;
            this.panel = panel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Point position = panel.getRectPosition();
            switch(direction) {
            case LEFT:
                position.x -= 3;
                break;
            case RIGHT:
                position.x += 3;
                break;
            case UP:
                position.y -= 3;
                break;
            case DOWN:
                position.y += 3;
                break;
            }

            panel.setRectPosition(position);
        }
    }

    private static void createAndShowUI() {
        JFrame frame = new JFrame("Move Rectangle");
        frame.getContentPane().add(new MoveRectangle());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowUI();
            }
        });
    }
}