//...

    int[] newArray = plusTen(array);

//...

public static int[] plusTen(int[] array) {

    //makes copy of array plus 10
    int[] newArray = new int[array.length];
    for (int i = 0; i < array.length; i++) {
        newArray[i] = array[i] + 10;
    }
    return newArray;
}