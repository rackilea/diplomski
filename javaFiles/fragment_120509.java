private static int mRows; // Number of rows 
private static int mCols; // Number of columns 
private static final ArrayList<LinkedList<Integer>> mMatrix = new ArrayList<>();


public static void main(String[] args) {
    mRows = 7; //example
    mCols = 4; //example

     //init your matrix
    for (int i = 0; i < mRows; i++) { //add new row 7 times
        mMatrix.add(new LinkedList<>());
        for (int j = 0; j < mCols; j++) {
            mMatrix.get(i).add(0); // add Integer with value 0 (4 times)
        }
    }

    //test
    setValue(5, 3, 159);
    System.out.println(getValue(5, 3));

}

public static void setValue(int r, int c, Integer v) {
    //before call be sure that r < mRows and c < mCols
    mMatrix.get(r).set(c, v); //replaces existing Integer
}

public static Integer getValue(int r, int c) {
    //before call be sure that r < mRows and c < mCols
    return mMatrix.get(r).get(c);
}