public static void main(String[] args) {
    boolean[] array = new boolean[] {false,true,true,false,true};
    int index = 0;
    while(!checkBooleanArray(array)) { //check
        array[index] = true;           //do something about it
        index++;                       //increasing the index and then check again
    }                                  //you obviously have to change the the part of "do something" and "increasing index" to match your wishes
    System.out.println(Arrays.toString(array));
}

public static boolean checkBooleanArray(boolean[] array) {
    for (boolean b : array)
        if (!b)
            return false;
    return true;
}