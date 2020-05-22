import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner (System.in);
        int yearInt = input.nextInt();
        input.close();

        while(true){

            yearInt+=1;
            String yearString = Integer.toString(yearInt);

            String [] numsString = yearString.split("");
            int l = numsString.length;
            int [] nums = new int [l];

            for(int i=0; i<l; i++){
                nums[i] = Integer.parseInt(numsString[i]);
            }

            Arrays.sort(nums);

            boolean different = true;

            for(int i=0;i<l-1; i++){
                if(nums[i]==nums[i+1]){
                    different = false;
                }
            }

            if (different){
                break;
            }
        }
        System.out.println(yearInt);
    }
}