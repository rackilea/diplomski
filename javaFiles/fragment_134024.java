int i;
for (i = 0; i < arr.length; i++) {
    arr[i] = sc.nextInt();
    System.out.println(arr[i]); // to print each element
}

// value of i is now 5, so arr[i] is invalid
System.out.println(arr[i-1]); // to print last element
System.out.println(Arrays.toString(arr)); // to print whole array