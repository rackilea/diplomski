package cruft;

import java.util.Random;

public class ArrayTester {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Integer[] myArray = new Integer[10];
        Random rand = new Random();
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = rand.nextInt();
        }        
        for (Integer value : myArray) {
            System.out.println(value);
        }
        System.out.println(String.format("max value: %d", findMax(myArray)));
    }

    public static int findMax(Integer [] values) {
        int max = Integer.MIN_VALUE;

        if (values != null) {
            for (Integer value : values) {
                if (value.compareTo(max) >= 1) {
                    max = value;
                }
            }
        }

        return max;
    }
}