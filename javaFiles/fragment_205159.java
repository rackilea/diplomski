// Create doBubbleSort method 
public static void doBubbleSort(int[] arr) {
    boolean needNextPass = true;
    // Array may be sorted and next pass not needed 
    // Swap list
    for (int i = 0; i < arr.length - 1; i++) {
        if (needNextPass) {
            needNextPass = false;
            for (int j = arr.length - 1; j > i; j--) {
                int temp;
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    needNextPass = true; // Next pass still needed
                }
            }
            printOut(i + 1, arr); // using printOut method
        }
    }
}