public class RandomTest {

    public static void main(String[] args) {
        int arr[] = new int[50];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);
            System.out.println(arr[i]);
        }
        int minimum = arr[0];
        for (int j = 1; j < arr.length; j++) {
            if (minimum > arr[j])
                minimum = arr[j];
        }
        System.out.println("Minimum value-->" + minimum);

    }
}