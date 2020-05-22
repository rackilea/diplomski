double[][] myArray = new double[90][];

public void init(int position){
    if(myArray[position] == null){
        myArray[position] = new double[3];
    }
}

public double[] get(int position) {
    init(position);
    return myArray[position];
}


public void set(int position, List<Double> listWithDataIWantToAssign){
    init(position);
    for (int i = 0; i < 3; i++) {
        myArray[position][i] = listWithDataIWantToAssign.get(i);
    }
}