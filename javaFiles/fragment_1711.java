public class HashSetTest {
public static Object obj = new Object();
public static void main(String... ar) {
    new AddingThread().start();
    new RemovalThread().start();
}