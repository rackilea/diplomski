Object arr[] = new Object[2];
arr[0] = '@'; // stores '@' as a Character wrapper object
arr[1] = 1; // stores 1 as an Integer wrapper object

for (Object o : arr) {
    System.out.println(o);
}