static int minimum(int [] array, int z, int k) {
    //if the we are examining the sub array consisting of one element
    if (z == k) {
        //the minimum of the array is that element
        return array[z];
    }
    //find the mid point of the array - also the mean of the two numbers, but that's not really relevant
    int s = (z + k) / 2;
    //find the minimum of the first half, by calling this function
    int min1 = minimum(array, z, s);
    //find the minimum of the second half, by calling this function
    int min2 = minimum(array, s+1, k);
    //return the smaller of the two halves
    return Math.min(min1, min2);
}