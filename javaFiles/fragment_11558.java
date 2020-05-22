public static int [] rotateLeft(int [] source, int k) {
    int arr[] = new int[source.length];

    for (int i = 0; i < arr.length; i++){
        arr[(i - k + source.length) % source.length] = source[i];
    }

    return arr; 
}