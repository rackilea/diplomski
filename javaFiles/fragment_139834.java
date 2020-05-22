public static void main(String[] args) {

    int[] inputArray = { 5, 3, 2, 4, 1, 0 };
    Arrays.sort(inputArray);
    System.out.println("First: " + getMinimum(inputArray, 0) + " Second: " + getMinimum(inputArray, 1));

}

public static int getMinimum(int[] inputArray, int position){
    return arr[position];
}