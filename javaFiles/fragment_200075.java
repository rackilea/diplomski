public void deleteValues(int[] a, int value) {
    int j=0;
    for(int i=0; i<a.length; i++) {
        if(a[i]!=value) {
            a[j] = a[i];
            j++;
        }   
    }
    // fill the rest of the array with zeros
    while(j<a.length) {
        a[j] = 0;
        j++;
    }   
}