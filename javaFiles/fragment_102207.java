public class Test {
    public static void main(String[] args) {
        char[] chars = { 'a', 'b', 'c' };
        System.out.println(String.valueOf(chars));  // abc
        Object object = chars;
        System.out.println(String.valueOf(object));  // [C@...
    }
}