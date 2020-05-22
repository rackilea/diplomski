public int compare(byte[] left, byte[] right) {
    int cmp = 0;
    for(int i = 0; i < 8 && cmp == 0; i++) { 
       cmp = (i == 0 || (left[i] >= 0 == right[i] >= 0)) ? left[i] - right[i] : right[i] - left[i]           
    }
    return cmp;
}