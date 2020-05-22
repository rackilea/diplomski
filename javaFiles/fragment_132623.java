import java.io.*;

class Main 
{
  public static void main(String[] args) throws IOException 
  {   
     int h_digit_1 = 0;
     int h_digit_0 = 0;
     int m_digit_1 = 0;
     int m_digit_0 = 0;

     int sums[] = new int[24];
     for( int sum: sums )
         sum=0;

     int currentSum = 0;

     for( int h = 0 ; h < 12 ; h++ )
     {
         if( h < 10 )
         {
            h_digit_1 = 0;
            h_digit_0 = h;
         }
         else
         {
            h_digit_1 = 1;
            h_digit_0 = h%10;
         }

         for( int m = 0 ; m < 60 ; m++ )
         {
             if( m < 10 )
             {
                 m_digit_1 = 0;
                 m_digit_0 = m;
             }
             else
             {
                 m_digit_1 = m/10;
                 m_digit_0 = m - m_digit_1*10;       
             }

             currentSum = h_digit_1+h_digit_0+m_digit_1+m_digit_0;
             sums[currentSum]++;//since currentSum is always less than 24, its safe to use it as index!! also, sums[currentSum] represents count of occurrence of currentSum!!
         }
     }

     for( int i = 0 ; i<sums.length ; i++ )
     {
         System.out.println(i+" is the sum of hour and minute digits "+ sums[i]+ " number of times");
     }
  }    
}