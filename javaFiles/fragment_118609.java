public static void main(String[] args) {
    int array[] = new int [7];
    array[0] = 5 ;
    array[1] = 10;
    array[2] = 11;
    array[3] = 19;
    array[4] = 13;
    array[5] = 14;
    array[6] = 16;
    reverse(array); // *** add this
    for(int i = 0; i < array.length; i++) {
        System.out.println(array[i]); 
    } 
}