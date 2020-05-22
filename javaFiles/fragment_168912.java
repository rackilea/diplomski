public void deleteInt(int index) {

    // can be 1 element shorter as we are going to erase 1 element
    // also, copying the contents of the original array in is a waste of time
    // so we just create it.
    int[] newInts = new int[myInts.length-1]; 

    // the easiest way is to use an extra variable to track the insertions in the
    // new array
    int j=0;
    for (int i=0; i < myInts.length; i++) {
        if (i != index) {
            newInts[j++] = myInts[i];
        }
    }

    // so now we have a new shortened copy of the array, but as the function is void,
    // its life ends here :)
}