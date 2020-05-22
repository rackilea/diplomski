public class Main {
    public static void main(String[] args) {
        new Main().runMe();
    }

    public void runMe() {
        new Test(this.getClass());
    }
}

class Test {
    public Test(Class clazz) {
        System.out.println("I was invoked from '" + clazz.getCanonicalName() + "' class.");
    }
}