class IntegerHolder{
    int firstValue;
    int secondValue;

    //This is a constructor, it creates the object.
    public IntegerHolder(int first, int second){
        firstValue = first;
        secondValue = second;
    }
}

public IntegerHolder someMethod(int x, String y, Object z) {
    return new IntegerHolder(x, x * 2);
}