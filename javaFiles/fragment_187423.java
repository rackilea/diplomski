public static void main (String args[]){
    int[] someArray = {1,2,3};

    Accumulator accumulator = new Accumulator(someArray);
}

public Accumulator(int[] X) {
    A= new int[X.length];
    for (int i=0; i<X.length; i++)
        A[i] = X[i];
}