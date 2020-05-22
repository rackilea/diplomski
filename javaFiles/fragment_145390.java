public static int[] getRandomPermutation (int length){

    // initialize array and fill it with {0,1,2...}
    int[] array = new int[length];
    for(int i = 0; i < array.length; i++)
        array[i] = i;

    for(int i = 0; i < length; i++){

        // randomly chosen position in array whose element
        // will be swapped with the element in position i
        // note that when i = 0, any position can chosen (0 thru length-1)
        // when i = 1, only positions 1 through length -1
                    // NOTE: r is an instance of java.util.Random
        int ran = i + r.nextInt (length-i);

        // perform swap
        int temp = array[i];
        array[i] = array[ran];
        array[ran] = temp;
    }                       
    return array;
}