public static void reverse(int[] array, int a, int b) { // both inclusive
    while(a<b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
        a++;
        b--;
   }
}