public class DefaultGameModel implements GameModel {

    private final List<Entity> entities;
    private Player player;

    private Long lastShot;

    public DefaultGameModel() {
        entities = new ArrayList<>(25);
    }

    @Override
    public Entity[] getEntities() {
        return entities.toArray(new Entity[0]);
    }

    @Override
    public void update(Rectangle bounds, Set<Direction> keys) {
        if (player == null) {
            player = new Player(bounds);
            entities.add(player);
        }

        Point p = player.getLocation();
        int xDelta = 0;
        if (keys.contains(Direction.LEFT)) {
            xDelta = -4;
        } else if (keys.contains(Direction.RIGHT)) {
            xDelta = 4;
        }
        p.x += xDelta;
        if (p.x <= bounds.x) {
            p.x = bounds.x;
        } else if (p.x + player.getSize().width >= bounds.x + bounds.width) {
            p.x = bounds.width - player.getSize().width;
        }
        player.setLocation(p);

        Iterator<Entity> it = entities.iterator();
        while (it.hasNext()) {
            Entity entity = it.next();
            if (entity instanceof Bullet) {
                Point location = entity.getLocation();
                Dimension size = entity.getSize();
                location.y -= size.height;
                if (location.y + size.height < bounds.y) {
                    it.remove();
                } else {
                    entity.setLocation(location);
                }
            }
        }

        if (keys.contains(Direction.SPACE)) {
            if (lastShot == null || System.currentTimeMillis() - lastShot > 100) {
                lastShot = System.currentTimeMillis();
                Bullet bullet = new Bullet();
                int x = p.x + ((player.getSize().width - bullet.getSize().width) / 2);
                int y = p.y - bullet.getSize().height;
                bullet.setLocation(new Point(x, y));

                entities.add(bullet);
            }
        }
    }

}

public class DefaultGameController implements GameController {

    private GameModel model;
    private GameView view;

    private Timer timer;

    private Set<Direction> keys = new HashSet<>(25);

    public DefaultGameController(GameModel gameModel, GameView gameView) {
        gameView.setController(this);

        view = gameView;
        model = gameModel;
    }

    @Override
    public Entity[] getEntities() {
        return model.getEntities();
    }

    @Override
    public void setDirection(Direction direction, boolean pressed) {
        if (pressed) {
            keys.add(direction);
        } else {
            keys.remove(direction);
        }
    }

    @Override
    public void start() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.update(view.getViewBounds(), Collections.unmodifiableSet(keys));
                view.repaint();
            }
        });
        timer.start();
    }

}

public class DefaultGameView extends JPanel implements GameView {

    private GameController controller;

    public DefaultGameView() {
        addKeyBinding("left.pressed", KeyEvent.VK_LEFT, true, new DirectionAction(Direction.LEFT, true));
        addKeyBinding("left.released", KeyEvent.VK_LEFT, false, new DirectionAction(Direction.LEFT, false));
        addKeyBinding("right.pressed", KeyEvent.VK_RIGHT, true, new DirectionAction(Direction.RIGHT, true));
        addKeyBinding("right.released", KeyEvent.VK_RIGHT, false, new DirectionAction(Direction.RIGHT, false));
        addKeyBinding("space.pressed", KeyEvent.VK_SPACE, true, new DirectionAction(Direction.SPACE, true));
        addKeyBinding("space.released", KeyEvent.VK_SPACE, false, new DirectionAction(Direction.SPACE, false));
    }

    protected void addKeyBinding(String name, int keyEvent, boolean pressed, DirectionAction action) {
        addKeyBinding(name, KeyStroke.getKeyStroke(keyEvent, 0, !pressed), action);
    }

    protected void addKeyBinding(String name, KeyStroke keyStroke, DirectionAction action) {
        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        inputMap.put(keyStroke, name);
        actionMap.put(name, action);
    }

    @Override
    public void setController(GameController controller) {
        this.controller = controller;
    }

    @Override
    public GameController getController() {
        return controller;
    }

    @Override
    public Rectangle getViewBounds() {
        return new Rectangle(new Point(0, 0), getSize());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        GameController controller = getController();
        for (Entity entity : controller.getEntities()) {
            // I don't trust you
            Graphics2D g2d = (Graphics2D) g.create();
            entity.paint(g2d);
            g2d.dispose();
        }
    }

    public class DirectionAction extends AbstractAction {

        private Direction direction;
        private boolean pressed;

        public DirectionAction(Direction direction, boolean pressed) {
            this.direction = direction;
            this.pressed = pressed;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getController().setDirection(direction, pressed);
        }

    }

}