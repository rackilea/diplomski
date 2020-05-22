public static class BadBuilder extends Rectangle.Builder {
    private double height;

    public BadBuilder height(double height) {
        System.out.println("height is set");
        this.height = height;
        return (BadBuilder) self();
    }

    @Override
    public Shape.Builder opacity(double opacity) {
        return new Shape.Builder();
    }

    public Rectangle build() {
        return new Rectangle(this);
    }
}