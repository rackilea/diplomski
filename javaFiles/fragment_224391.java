for(int i = 2; i < myArray.length; i++) {
    if (myArray[i]) {continue;}
    j = 2 * i;
    while(j < myArray.length) {
        myArray[j] = true;
        j += i;
    }
}