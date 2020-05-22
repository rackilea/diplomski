// Initialize variable to null
public static void main(String[] args) {
    Formatter x = null;
    try {
        x = new Formatter("note1.txt");
        // use x here
    } catch (Exception e) {
        e.printStackTrace(System.out); // Better way to print the exception
    }
    if (x != null) {
        // or use x here
        x.close();
    }
}