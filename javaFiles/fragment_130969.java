package numThree;

import java.util.Scanner;
import java.util.Arrays;

public class sort {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] num = new int[3];


        //INPUT DATA
        System.out.println("Enter integers : ");

        for(int i=0;i<=num.length;i++){

            num[i]=sc.nextInt();

        }

        sort(num);

    }

    //SORTING
    public static void sort (int[] num){
       boolean swapped = true;
       while(swapped){ 
           swapped = false;
           for(int i=0;i<num.length-1;i++){

                if(num[i]>num[i+1]){
                    int temp = num[i];
                    num[i] = num[i+1];
                    num[i+1] = temp;
                    swapped = true;
                }
           }
       }
       System.out.println("Sorted Result : "+Arrays.toString(num));
    }
}