int[] arr = {1,2,3,4,5,6};

System.out.println("Before:");
for (int i = 0; i < arr.length; i++) {
    System.out.print(arr[i] + ", ");
}
System.out.println():


if (arr.length > 0) {
    int first = arr[0];

    for (int i = 0; i < arr.length-1; i++) {
        arr[i] = arr[i+1];
    }

    arr[arr.length-1] = first;
}

System.out.println("After:");
for (int i = 0; i < arr.length; i++) {
    System.out.print(arr[i] + ", ");
}