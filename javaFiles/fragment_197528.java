import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {

  public static void main(String[] args) {
      /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      int b;
      long n;
      long k;
      long []array;
      array = new long [100005]; // biggest size that can be possible
      int count;
      long sum = 0;
      for(int i = 0; i < t; i++){
          n = sc.nextLong();
          k = sc.nextLong();
          b = sc.nextInt();
          count = 0;
          sum = 0;
          //no need to create it again and again, just create it once but create it as the biggest size
          for (int j = 0; j < b; j++){
              array[b - 1 - j]=j+1;
              sum +=(j+1);
          }
          while (true){
              while (sum < n && count < b && k > b){
                  if ((sum + (k - count - array[count]) )< n) {
                      sum += k - count - array[count];
                      array[count]+=k - count - array[count];
                      }
                  else {
                      System.out.println (n - sum);
                      array[count]+= n - sum;
                      sum += n - sum;  
                  }                    
                  if (array[count] == k - count) count++;
              }
              if (sum == n) {
                  for (int x = 0; x < b; x++){
                      System.out.print (array[x]);
                      if (x < b - 1) System.out.print(" ");
                      else System.out.print("\n");
                  }    
                  break;
              }
              else {
                  System.out.println ("-1");
                  break;
              }
          }
      }
  }
}