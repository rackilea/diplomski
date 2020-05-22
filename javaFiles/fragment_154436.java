public class Array {
private int[] myArr;
private int count;

public Array(int length) {
    myArr = new int[length];
    count = 0;
}

public int[] getInnerArray() {
    return myArr;
}

public static void processArray(Array array) {
    int[] innerArray = array.getInnerArray();
    int length = innerArray.length;
    for (int i=0; i<length; i++) {
        System.out.println("Next [" + i + "] is - " + innerArray[i]);
    }
}