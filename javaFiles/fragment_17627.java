//first way
System.out.println(Arrays.toString(arr));
//second way
for(int i : arr) {
   System.out.print(i + " ");
}
//third way
for(int i = 0; i < arr.length; ++i) {
    System.out.print(arr[i] + " ");
}