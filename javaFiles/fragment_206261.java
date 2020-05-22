public static int biggest(int nr1, int nr2, int nr3){
    int biggest = 0;

    if (nr1>nr2 && nr1>nr3){
        biggest = nr1;
    } else if (nr2>nr1 && nr2>nr3){
        biggest = nr2;
    } else if (nr3>nr1 && nr3>nr2){
        biggest = nr3;
    }
    return biggest;
}

public static int smallest(int nr1, int nr2, int nr3){
    int smallest = 0;
    if (nr1<nr2 && nr1<nr3){
        smallest = nr1;
    } else if (nr2<nr1 && nr2<nr3){
        smallest = nr2;
    } else if (nr3<nr1 && nr3<nr2){
        // nr3=smallest;
        smallest = nr3;
    }
    return smallest;
}