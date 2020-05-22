public class Test {
    public String[] dum() {
        String[] x = {"Not sure"};
        return x;
    }

    public static void main(String[] args) {
        Test t = new Test();
        String[][] words = {t.dum()};
        System.out.println(words[0][0]); // prints "Not sure"
    }
}