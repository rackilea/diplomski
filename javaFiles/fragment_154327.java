public class Main {
    enum WORKDAYS { Monday, Tuesday, Wednesday, Thursday, Friday; }

    public static void main(String[] args) {
        System.out.println(WORKDAYS.values().length);
        // prints 5
    }
}