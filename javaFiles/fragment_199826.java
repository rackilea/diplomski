import java.io.*;
import java.util.*;

public class hcrkarryjump {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[]=new int[n];
        for(int k=0;k<n;k++)
            a[k]=sc.nextInt();
        int i=0;
        while(i<n){
            // Check if we have something to do
            if(a[i]==1){
                // We do stuff
                if(a[i+1]==0 &&(i+m>=n-1))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
            // and increment for the while check and next loop
            i++;
        }
    }
}