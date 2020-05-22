// If formatter is auto-closeable, use try-with-resources
public static void main(String[] args) {
    try (Formatter x = new Formatter("note1.txt")) {
        // use x here
    } catch (Exception e) {
        System.out.println("Error: " + e);
    }
}