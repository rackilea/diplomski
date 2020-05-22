package com.rabin;

import java.util.StringJoiner;

/**
 * 
 */
public class BITree {
    /**
     * O(logn)
     * @param arr
     * @param index
     * @param val
     */
    void update(int arr[],int index, int val)
    {
        index++;
        for(; index <= arr.length-1; index += index&-index)
            arr[index] += val;
    }

    /**
     * O(logn)
     * @param arr
     * @param noOfElements
     * @return
     */
    int query(int[] arr,int noOfElements)
    {
        int sum = 0;
        for(; noOfElements > 0; noOfElements -= noOfElements&-noOfElements)
            sum += arr[noOfElements-1];
        return sum;
    }

    /**
     * O(n)
     * @param arr
     */
    void toBIT(int[] arr){
        int n = arr.length;
        for(int i=1;i<=n;i++){
            int j = i+ (i & -i);
            if(j <= n)
                arr[j-1] += arr[i-1];
        }
    }

    static String arrayToString(int[] arr){
        StringJoiner sj = new StringJoiner(",","[","]");
        for(int i = 0; i< arr.length ;i++){
            sj.add(String.valueOf(arr[i]));
        }
        return sj.toString();
    }

    public static void main(String[] args) {
        int[] arr = {5,1,6,4,2,3,3};
        BITree bit = new BITree();

        System.out.println("Original Array:" +arrayToString(arr));
        bit.toBIT(arr);
        System.out.println("BIT Array:" +arrayToString(arr));
        System.out.println("Sum of first 5 nos : "+ bit.query(arr,5));
        bit.update(arr,0,8);
        System.out.println("Sum of first 5 nos after update : "+ bit.query(arr,5));

    }
}