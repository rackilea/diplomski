public class SetInt {
    int[] setArray = new int[52];

    public void add(int a) {
        if (a < setArray.length - 2) {
            setArray[a] = a;
        }
    }

    /*
     * add a to the set in the correct position
     * 
     * @param a the value to be added
     */

    public SetInt intersection(SetInt anySet) {
        SetInt temp = new SetInt();
        for (int i = 0; i < setArray.length; i++) {
            for (int j = 0; j < anySet.setArray.length; j++) {
                if (setArray[i] == anySet.setArray[j]) {
                    temp.setArray[i] = setArray[i];
                }
            }
        }
        return temp;
    }

    /*
     * returns the set of integers common to both the set passed in as an
     * argument and the set the method is called on
     * 
     * @param anySet - the set to be intersected
     * 
     * @return a set containing the result of the intersection
     */

    public SetInt union(SetInt anySet) {
        SetInt temp = new SetInt();
        for (int i = 0; i < setArray.length; i++) {
            for (int j = 0; j < anySet.setArray.length; j++) {
                temp.setArray[i] = setArray[i];
                if (anySet.setArray[j] != 0) {
                    temp.setArray[j] = anySet.setArray[j];
                }
            }
        }
        return temp;
    }
    /*
     * returns the set of integers which are in either the set passed in as an
     * argument or the set the method is called on
     * 
     * @param anySet - one of the sets in the union
     * 
     * @return a set containing the result of the union
     */

}