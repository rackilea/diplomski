// Wrap in an unchecked exception
public static void main(String[] args) {
    try {
        Formatter x = new Formatter("note1.txt");
        // use x here
        x.close();
    } catch (Exception e) {
        throw new RuntimeException("Error", e); // Include original exception as the cause
    }
}