int[] array = ...
int i = 0;
try {
    while(true) {
       array[i]++;
       i++;
    }
} catch(ArrayIndexOutOfBoundsException e) {
    // Loop finished
}