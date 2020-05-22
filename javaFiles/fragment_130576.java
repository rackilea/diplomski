import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        // Write Your Code Here
        int numSwaps=0;
        for(int i=0;i<n-1;i++){
            if(a[i+1]==n){
                break;
            } else if(a[i]>a[i+1]){
                int temp=a[i];
                a[i]=a[i+1];
                a[i+1]=temp;
                numSwaps++;
            }
        }
        //firstElement=a[0];
        //lastElement=a[n-1];
        System.out.println("Array is sorted in"+" "+numSwaps+" "+"swaps."+"\n"+"First Element:"+" "+a[0]+"\n"+"Last Element:"+" "+a[n-1]);
}