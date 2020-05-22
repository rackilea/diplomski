import java.util.*;

class Random123 {

    public static void main(String args[]){
        int arr[] = new int[1000];
        int num;
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++){
            num = 1 + rand.nextInt(10);
            arr[i] = num;
            System.out.println("Random No. Index: " + i + "\t Value : " + arr[i]);
        }
    }
}