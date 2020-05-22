public class Utils {
    private int value = 5;
    Utils () {
        System.out.println("Should be mocked");
    }
    Utils (int param) {
        this.value = param;
        System.out.println("Should be mocked");
    }
    public int someMethod() {
        System.out.println("Should be mocked");
        return value;
    }
}