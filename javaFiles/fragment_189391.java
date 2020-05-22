public class Test {
static Scanner user = new Scanner(System.in);
public static void main(String[] args) {
    Test2 t = new Test2();
    while(true) {
        try {
            t.run(user.nextInt());
            Thread.Sleep(50);
        } catch (Exception e) {
        }
    }
}