public int[] acquireArray(Scanner sc) {
    System.out.println("Length? ");
    int len = sc.nextInt();
    int[] arr = new int[len];
    for(int i = 0; i < len; i++) {
        System.out.println("Enter element " + (i+1) + ":");
        arr[i] = sc.nextInt();
    }
    return arr;
}