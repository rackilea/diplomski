public static int biggest(int nr1, int nr2, int nr3){
    int biggest = Math.max(nr1, nr2);
    return Math.max(biggest, nr3);
}

public static int smallest(int nr1, int nr2, int nr3){
    int smallest = Math.min(nr1, nr2);
    return Math.min(smallest, nr3);
}