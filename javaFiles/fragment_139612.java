public class Test {
    public static void main(String[] args) {
        Integer[] arr1 = { 1, 2 };
        Integer[] arr2 = { 1, 2 };

        System.out.println(arr1.equals(arr2));
        System.out.println(arr1.hashCode() + " / " + arr2.hashCode());
    }
}