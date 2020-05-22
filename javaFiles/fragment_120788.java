public class DefaultGameModel implements GameModel {

    private int[][] maze
            = {{1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1}};

    private int[] playerLocation = new int[]{1, 0};

    @Override
    public int[][] getMaze() {
        return maze;
    }

    @Override
    public int[] getPlayerLocation() {
        return playerLocation;
    }

    @Override
    public void setPlayerLocation(int[] playerLocation) {
        this.playerLocation = playerLocation;
    }

    @Override
    public void update(Set<Direction> directions) {
        int[] location = getPlayerLocation();
        int[][] maze = getMaze();
        int x = location[0];
        int y = location[1];
        if (directions.contains(Direction.UP)) {
            y--;
        } else if (directions.contains(Direction.DOWN)) {
            y++;
        }
        if (directions.contains(Direction.LEFT)) {
            x--;
        } else if (directions.contains(Direction.RIGHT)) {
            x++;
        }
        if (x < 0) {
            x = 0;
        } else if (x >= maze[0].length) {
            x = maze[0].length - 1;
        }
        if (y < 0) {
            y = 0;
        } else if (y >= maze.length) {
            y = maze.length - 1;
        }

        if (maze[y][x] == 0) {
            location = new int[]{x, y};
            setPlayerLocation(location);
        }

    }

}

public class DefaultGameController implements GameController {

    private GameView view;
    private GameModel model;

    private Timer timer;

    private Set<Direction> directions;

    public DefaultGameController(GameView view, GameModel model) {
        this.view = view;
        this.model = model;
        directions = new HashSet<>(4);
        view.setController(this);
    }

    public GameView getView() {
        return view;
    }

    public GameModel getModel() {
        return model;
    }

    @Override
    public int[][] getMaze() {
        return getModel().getMaze();
    }

    @Override
    public int[] getPlayerLocation() {
        return getModel().getPlayerLocation();
    }

    @Override
    public void setDirectionPressed(Direction direction, boolean pressed) {
        if (pressed) {
            directions.add(direction);
        } else {
            directions.remove(direction);
        }
    }

    @Override
    public void start() {
        // This isn't really required for this type of simple example, but what
        // does do is demonstrates at least one possible solution for simple
        // game loop
        //
        // Because of the basic nature of the game, it would be possible to have
        // setDirectionPressed call model.update and view.update
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getModel().update(Collections.unmodifiableSet(directions));
                getView().update();
            }
        });
        timer.start();
    }

}

public class DefaultGameView extends JPanel implements GameView {

    private GameController controller;

    public DefaultGameView() {
        addKeyBinding("left.pressed", KeyEvent.VK_LEFT, true, new MoveAction(Direction.LEFT, true));
        addKeyBinding("left.released", KeyEvent.VK_LEFT, false, new MoveAction(Direction.LEFT, false));
        addKeyBinding("right.pressed", KeyEvent.VK_RIGHT, true, new MoveAction(Direction.RIGHT, true));
        addKeyBinding("right.released", KeyEvent.VK_RIGHT, false, new MoveAction(Direction.RIGHT, false));
        addKeyBinding("up.pressed", KeyEvent.VK_UP, true, new MoveAction(Direction.UP, true));
        addKeyBinding("up.released", KeyEvent.VK_UP, false, new MoveAction(Direction.UP, false));
        addKeyBinding("down.pressed", KeyEvent.VK_DOWN, true, new MoveAction(Direction.DOWN, true));
        addKeyBinding("down.released", KeyEvent.VK_DOWN, false, new MoveAction(Direction.DOWN, false));
    }

    @Override
    public void update() {
        repaint();
    }

    @Override
    public void setController(GameController controller) {
        this.controller = controller;
        revalidate();
        repaint();
    }

    @Override
    public GameController getController() {
        return controller;
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = new Dimension(13 * 20, 10 * 20);
        GameController controller = getController();
        if (controller != null) {
            int[][] maze = controller.getMaze();
            size.height = maze.length * 20;
            size.width = maze[0].length * 20;
        }
        return size;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        GameController controller = getController();
        if (controller != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            Dimension size = getPreferredSize();
            int x = (getWidth() - size.width) / 2;
            int y = (getHeight() - size.height) / 2;

            int[][] maze = controller.getMaze();
            for (int row = 0; row < maze.length; row++) {
                int yPos = y + (row * 20);
                for (int col = 0; col < maze[row].length; col++) {
                    int xPos = x + (col * 20);
                    switch (maze[row][col]) {
                        case 1:
                            g2d.setColor(Color.BLACK);
                            break;
                        default:
                            g2d.setColor(Color.WHITE);
                            break;
                    }
                    g2d.fillRect(xPos, yPos, 20, 20);
                }
            }
            int[] playerLocation = controller.getPlayerLocation();
            int xPos = x + (playerLocation[0] * 20);
            int yPos = y + (playerLocation[1] * 20);
            g2d.setColor(Color.RED);
            g2d.fillRect(xPos, yPos, 20, 20);
            g2d.dispose();
        }
    }

    protected void addKeyBinding(String name, int virtualKey, boolean pressed, MoveAction action) {
        addKeyBinding(name, KeyStroke.getKeyStroke(virtualKey, 0, !pressed), action);
    }

    protected void addKeyBinding(String name, KeyStroke keyStroke, MoveAction action) {
        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        inputMap.put(keyStroke, name);
        actionMap.put(name, action);
    }

    public class MoveAction extends AbstractAction {
        private Direction direction;
        private boolean pressed;

        public MoveAction(Direction direction, boolean pressed) {
            this.direction = direction;
            this.pressed = pressed;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            GameController controller = getController();
            if (controller != null) {
                controller.setDirectionPressed(direction, pressed);
            }
        }

    }

}