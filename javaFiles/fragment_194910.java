package lesson5;
import java.util.Scanner;

public class task3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int [] masarray = new int [10];
    int a,b,c,d,f,g,j,m,n,l;

    int flag_even =0;
    int min_even = 0;
    float sum_even=0;
    float sum_odd=0;
    int total_even=0;
    int total_odd=0;

    System.out.println("input first  number of array");
    a=sc.nextInt();
    masarray [0]= a;

    System.out.println("input second  number of array");
    b=sc.nextInt();
    masarray [1]= b;

    System.out.println("input third  number of array");
    c=sc.nextInt();
    masarray [2]= c;

    System.out.println("input fourth  number of array");
    d=sc.nextInt();
    masarray [3]= d;

    System.out.println("input fiveth  number of array");
    f=sc.nextInt();
    masarray [4]= f;

    System.out.println("input sixth  number of array");
    g=sc.nextInt();
    masarray [5]= g;

    System.out.println("input seventh  number of array");
    j=sc.nextInt();
    masarray [6]= j;

    System.out.println("input eighth  number of array");
    m=sc.nextInt();
    masarray [7]= m;

    System.out.println("input nineth number of array");
    n=sc.nextInt();
    masarray [8]= n;

    System.out.println("input tenth  number of array");
    l=sc.nextInt();
    masarray [9]= l;

    for ( int i =0; i < masarray.length; i++){
        if (masarray[i]%2==0){

            if(flag_even==0)//Assigning first even number found in array to min_even to initialize it
            {
                min_even=masarray[i];
                flag_even=1;//Initialization done
            }

            else if(min_even>masarray[i])
                min_even=masarray[i];

            sum_even+=masarray[i];//calculates sum of all even numbers
            System.out.println("even number = " + masarray[i]); 

            total_even++;//counting total number of even numbers
        }

        else
        {
            sum_odd=masarray[i];//calculates sum of all odd numbers
            total_odd++;//counting total number of odd numbers
        }
    }

    if(flag_even==0)
        System.out.println("No even number present in array!");
    else
    {   
        System.out.println("Minimum Even number in given array is:"+min_even);
        System.out.println("Average of Even numbers in given array is:"+(sum_even/total_even));
    }

    if(total_odd==0)
        System.out.println("No odd number present in array!");
    else
        System.out.println("Average of Odd number in given array is:"+(sum_odd/total_odd));

  }
}