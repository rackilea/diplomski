package quadraticResolver;

import java.util.Arrays;

public class factorisedEquation {

    public factorisedEquation() {
        System.out.println(Arrays.toString(getMultiples(4))); //test
    }

    private int[] addElement(int[] array, int appendNum) {

        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = appendNum;
        return array;
    }

    private int[] getMultiples(int product) {
        int[] multiples = new int[]{1}; //The array

        for (int i = 2; i <= product; i = i + 1) {
            if ((product % i == 0) && (i != 1)) { //if Divisible by the argument product, add it to the array.
                multiples = addElement(multiples, i);
            }
        }
        return multiples; //return the new array
    }
    public static void main(String []args){
        factorisedEquation f = new factorisedEquation();
     }

}