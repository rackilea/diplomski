// Put close() inside try block
public static void main(String[] args) {
    try {
        Formatter x = new Formatter("note1.txt");
        // use x here
        x.close();
    } catch (Exception e) {
        System.out.println("Error: " + e); // Print the exception too
    }
}