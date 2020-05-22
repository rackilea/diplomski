public class Integers {
    void createIntegers(int[] arr) {
        for (int n = 0; n < arr.length; n++){
            arr[n] = 100*n;
        }                
    }

    void printIntegers(int[] arr) {
        for (int index = 0; index < arr.length; index++) {
            System.out.println(arr[index]);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        Integers createIntegers = new Integers();
        createIntegers.createIntegers(arr);
        createIntegers.printIntegers(arr);
    }
}