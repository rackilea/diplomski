public static class Fruit<C extends Enum<C>> {
    protected C color;

    public void setColor(C color) {
        this.color = color;
    }

}

public static class Apple extends Fruit<Apple.Color> {
    public enum Color {
        Red, Green;
    }

    public Apple() {
        setColor(Color.Red);
    }

}

public static class Lemon extends Fruit<Lemon.Color>{
    public enum Color {
        Yellow, Green;
    }

    public Lemon() {
        setColor(Color.Yellow);
    }

}