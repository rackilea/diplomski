enum PieceType {
    BISHOP {
        @Override public void move() { /* whatever */ }
    },
    PEON {
        ...
    }

    private final BufferedImage image;

    PieceType() {
        image = ImageIO.read(ClassLoader.getSystemResource("chess/img/" + name().toLowerCase() + ".png"));
    }

    public abstract void move(); // or whatever

}