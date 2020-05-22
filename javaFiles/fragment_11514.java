// Cascade exception to caller (JVM will print it for you when main() throws exception)
public static void main(String[] args) throws Exception {
    Formatter x = new Formatter("note1.txt");
    // use x here
    x.close();
}