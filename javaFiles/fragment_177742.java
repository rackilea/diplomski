interface Colored {
    Color getColor();
}

// in Color
public static boolean isRed(Colored colored) {
    return Objects.equals(colored.getColor(), RED);
}