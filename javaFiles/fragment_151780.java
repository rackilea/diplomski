import org.apache.commons.lang.ArrayUtils;

public class Main {

    public static void main(String[] args) {

        int[][] myArray = {{1, 4, 5, 6, 9}, {9, 1, 3, 2}};

        System.out.println(arrayContain(myArray, 2));
    }

    public static boolean arrayContain(int[][] myArray, int valueToFind) {
        if (ArrayUtils.contains(myArray, 1)) return true;

        for (int i = 0; i < myArray.length; i++) {
            if (ArrayUtils.contains(myArray[i], valueToFind)) return true;
        }
        return false;
    }
}