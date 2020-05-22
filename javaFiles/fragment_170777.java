public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    //int Array1[];     
    System.out.println("How many numaric elements: ");

    int n = input.nextInt();
    int arr[] = new int[n];// solve 1st problem
    for (int i = 0; i < n; i++) {
        System.out.println("Enter number: " +(i+1));
        int number = input.nextInt();
        arr[i]=number;//init  array  by user input data
    }
    System.out.println("Original numeric array : " + Arrays.toString(arr));
    Arrays.sort(arr);
    System.out.println("Sorted numeric array : " + Arrays.toString(arr));
}