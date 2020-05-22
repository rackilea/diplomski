public class MyClass {

    public static int[] myArray = {5, 2, 6, 82};

    public static void main(String[] args) {
        System.out.println(sum(0, 3));
    }

    public static int sum(int low, int high) {
        int sum = 0;
        for (int i = low; i <= high; i++) {
            sum += myArray[i];
        }
        return sum;
    }
}