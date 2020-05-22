static public Rational[] newArray(int size) {
    Rational[] arr = new Rational[size];
    for (int i = 0; i < size; i++)
        arr[i] = new Rational();
    return arr;
}

static public Rational[][] newMatrix(int h, int w) {
    Rational[][] m = new Rational[h][];
    for (int i = 0; i < h; i++) 
        m[i] = newArray(w);
    return m;
}