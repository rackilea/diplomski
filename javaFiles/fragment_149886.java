public class Test {
    public static void main(String[] args) {
        InputStream stream = Test.class.getResourceAsStream("/test.txt");
        Scanner s = new Scanner(stream);
        while (s.hasNext()) {
            System.out.println(s.next());
        }
    }
}