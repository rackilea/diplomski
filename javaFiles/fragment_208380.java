public class MyMates {
    private static TreeSet<String> myTable = new TreeSet<String>();
    private static String[][] names;

    public MyMates() {
        super();
        myTable = new TreeSet<String>();
    }

    public static String methodA(String aTemp) {
        names = new String[][] {
                { "Amy", "Jose", "Jeremy", "Alice", "Patrick" },
                { "Alan", "Amy", "Jeremy", "Helen", "Alexi" },
                { "Adel", "Aaron", "Amy", "James", "Alice" } };

        return aTemp;
    }

    public static String methodB(String bTemp) {

        for (int row = 0; row < names.length; row++) {
            for (int i = 0; i < names[row].length; i++) {
                myTable.add(names[row][i]);
                System.out.println(myTable);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        methodA("");
        methodB("");
    }
}