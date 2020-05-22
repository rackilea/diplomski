public class MyClass {
    private int a, b;
    private int[] array;

    public int hashCode() {
         return (31 * (31 * Arrays.hashCode(array) + a)) + b;
    }