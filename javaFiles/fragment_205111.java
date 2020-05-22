public static void shiftLeft(int [] source, int k){
     int newLength = source.length - k;
     for(int i = 0; i < source.length; i++) {
        source[i] = i < newLength ? source[i + k] : 0;
    }
}