public class pp {
    static int x = 4;
    int y = 8;
    static int z = y + 5; // <<=== This does not compile

    public static void main(String[] args) {
        System.out.println(y); // <<=== This does not compile either
    }
}