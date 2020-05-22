public class Withdraw
{
 public static void main(String[] args)
 {

      int moneyValue=2430;
      int[] noteValues= {500,100,50,20,10,1};
      if(moneyValue>15000)
      {
          System.out.println("ATM Cash Limit exceeds.");
      }
      else
      {
         for(int i=0;i<noteValues.length && moneyValue!=0;i++)
         {
             if(moneyValue>=noteValues[i])
                 System.out.println("No of "+noteValues[i]+"'s"+" :"+moneyValue/noteValues[i]);
             moneyValue=moneyValue%noteValues[i];
         }
      }
  }
}   



 Output:
  No of 500's :4
  No of 100's :4
  No of 20's :1
  No of 10's :1