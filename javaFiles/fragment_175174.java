public class B {
    B() {
        URL resource = getClass().getClassLoader().getResource("csvFile.csv");
        System.out.println("Found "+resource);
    }
    public static void main(String... args) {
        new B();
    }
}