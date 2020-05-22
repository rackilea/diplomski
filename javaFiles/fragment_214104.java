import java.util.Scanner;
 import java.util.Random;
 public class Insert {
static Scanner input=new Scanner(System.in);
    public static void main(String [] args){
 Random rand=new Random();
 int max,min;
 System.out.println("enter the maximum number");
 max=input.nextInt();
 System.out.println("enter the minimum number");
 min=input.nextInt();
 int range=max-min+1;
 int arr[]=new int[100];
 for(int i=0;i<100;i++){
      int random=rand.nextInt(max-min+1)+min;
      arr[i]=random;  
  }

 for(int i=0;i<100;i++){
      System.out.println(arr[i]);

  }


 }