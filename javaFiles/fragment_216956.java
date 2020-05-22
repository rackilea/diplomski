enum Color { BLACK, WHITE; }

public static void main(String[] args) {
    Color c = Enum.valueOf(Color.class, "black".toUpperCase());
    System.out.println(c); // prints "BLACK"
}