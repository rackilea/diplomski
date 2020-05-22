package pkg;
public class pkg {
    public static void main(String[] args) {
        main(new OutputStreamWriter(System.out), args);
    }

    public static void main(Writer writer, String[] args) {
        PrintWriter out = new PrintWriter(writer);
        out.println("Hello");
    }
}