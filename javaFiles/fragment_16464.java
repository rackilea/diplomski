public class FixedColumn {

    public static void main(String[] args) {
        String[] test = {"13333","2qweqwe","3dddd"};
        String[] test2 = {"dsds4","6","6e"};
        String format = "%-20s";        
        for (String s : test) {
            System.out.printf(format, s);
        }
        System.out.println();
        for (String s : test2) {
            System.out.printf(format, s);
        }

    }

}