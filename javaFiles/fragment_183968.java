class Functionality {

static int[] first() {
    System.out.println("Enter the number of element in array");
    Scanner num = new Scanner(System.in);
    int data = num.nextInt();
    //return data;
    Scanner ar = new Scanner(System.in);
    int arr[] = new int[data];
    System.out.println("Enter " + data + " Numbers");
    for (int i = 0; i < data; i++) {
        System.out.println("Enter NUmber :" + (i + 1));
        arr[i] = num.nextInt();
    }
    System.out.println();
    System.out.println(Arrays.toString(arr));
    return arr;
}

public static void main(String[] args) {
    int arr[] = first();
    add(arr);
    delete(arr);

}

static void add(int arr[]) {
    System.out.println("Enter the number you want to add");
    Scanner one = new Scanner(System.in);
    int naya = one.nextInt();
    for (int i = 0; i <= arr.length - 1; i++) {
        arr[i] = arr[i] + naya;
    }
    System.out.println("The added array is");
    System.out.println(Arrays.toString(arr));
}

static void delete(int arr[]) {
    System.out.println("Enter the number you want to substract");
    Scanner two = new Scanner(System.in);
    int arko = two.nextInt();
    for (int i = 0; i <= arr.length - 1; i++) {
        arr[i] = arr[i] - arko;
    }
    System.out.println("The Substracted array is");
    System.out.println(Arrays.toString(arr));

}