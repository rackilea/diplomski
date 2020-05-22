import java.util.*;

public class sumPositiveAverage {

public static void main(String[] args)
{
   int sum_even = 0;
   int sum_odd = 0;
   int sum_negative = 0;
   int sum_positive = 0;

   int count_even = 0;
   int count_odd = 0;
   int count_negative = 0;
   int count_positive = 0;

   double avg_sum_even = 0;
   double avg_sum_odd = 0;
   double avg_sum_negative = 0;
   double avg_sum_positive = 0;

   int sum = 0;
   int count = 0;
   Scanner input = new Scanner(System.in);
   int data = 0;
   do
   {
       System.out.print("Type in a positive or negative number and press enter key, if 0 is entered program stops: ");
       data = input.nextInt();


       if(data > 0){

           if(data%2 == 0){
           //even number
           sum_even = sum_even + data;
           count_even++;
           }else{

               //odd
               sum_odd = sum_odd + data;
               count_odd++;

           }

           sum_positive = sum_positive + data;
           count_positive++;
       }else if(data < 0) {

           //negative number
       sum_negative = sum_negative + data;
       count_negative++;

       }


    }
    //Stops if the value of data is ZERO(0) and continues if it's not
    while(data != 0);

   //here means zero has been entered

     if(count_positive > 0) { avg_sum_positive = (double)sum_positive/count_positive; }
     if(count_negative > 0) { avg_sum_negative = (double)sum_negative/count_negative; }
     if(count_even > 0) { avg_sum_even = (double)sum_even/count_even; }
     if(count_odd > 0) { avg_sum_odd = (double)sum_odd/count_odd; } 


     System.out.println("Sum of Positive Numbers = " + sum_positive);
     System.out.println("Sum of negative Numbers = " + sum_negative);
     System.out.println("Sum of odd Numbers = " + sum_odd);
     System.out.println("Sum of even Numbers = " + sum_even);

     System.out.println("Count of Positive Numbers = " + count_positive);
     System.out.println("Count of negative Numbers = " + count_negative);
     System.out.println("Count of odd Numbers = " + count_odd);
     System.out.println("Count of even Numbers = " + count_even);

     System.out.println("Average of Positive Numbers = " + avg_sum_positive);
     System.out.println("Average of negative Numbers = " + avg_sum_negative);
     System.out.println("Average of odd Numbers = " + avg_sum_odd);
     System.out.println("Average of even Numbers = " + avg_sum_even);


}//closing main
} // closing class