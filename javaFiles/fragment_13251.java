import somepackage.*;

public class Test {
    public static final void main(String[] args) {
        BuggyClassUser u = new BuggyClassUser();
        System.out.println(u.useBuggyClass());
    }
}