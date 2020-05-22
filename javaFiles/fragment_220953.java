class Player {
    private final Color color;

    Player(final Color color) {
        this.color = color;
    }

    void doSomething(final Group root, final double x, final double y) {
        Rectangle r = new Rectangle(x, y, 5, 5);
        r.setFill(color);
        root.getChildren().add(r);
    }
}