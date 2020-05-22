import java.util.Scanner;

public class Main{

  public static void main( String args[]){

    System.out.println("enter the number of elements :" );
     Scanner s1= new Scanner(System.in);
      int N = s1.nextInt();
        System.out.println("enter the price of all the elements in ascending 
    order :");

         float[] price =new float[N];

       for(int i=0; i<N;i++){

          price[i]=s1.nextFloat();
          System.out.println(price[i]);
           }

           }
}