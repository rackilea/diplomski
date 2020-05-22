public class Driver {

    public static void main(String[] args) {
        new Driver();
    }

    final int value;

    public Driver() {
        print(this);
        value = 3;
    }

    static void print(Driver driver) {
        System.out.println(driver.value);
    }

}