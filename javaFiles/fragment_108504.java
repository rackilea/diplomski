/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

//StackOverflow question. 
//http://stackoverflow.com/questions/32045039/array-elements-beginning-and-ending-with-1s-by-equal-number-at-both-end-and-oth/32045312#32045312


/* Name of the class has to be "Main" only if the class is public. */
class OneTwoOne {

    static  int i, t1 = 0, t2 = 0, te = 0, tb = 0, tc = 0;
    public static void main(String[] args) {

    int a [] = new int[]{1, 1, 2, 2, 2, 1, 1};
        int retunValue = OneTwoOne.is121Array(a);
        System.out.println("Number of 1s in starting ::"+te +"\n Number of 1s in the end ::"+ tb +"");
        System.out.println("Return value :: "+retunValue );


}

public static int is121Array(int[] a) {
    for (i = 0; i < a.length; i++) {//checking 1's and 2's in an array

        if (a[i] == 1) {

            t1 = 1;
        }
        if (a[i] == 2) {
            t2 = 2;
        }
    }
    int length = a.length;
    for (i = 0; i < length/2; i++) {//counting number of 1's at begining of array

        if (a[i] == 1) {

            tb++;
        }

    }

    for (i = a.length-1; i >= length/2; i--) {//counting number of 1's at end of array

        if (a[i] == 1) {
            te++;
        }

    }
    if (te == tb)
        return 1;
    else
        return 0;
}
}