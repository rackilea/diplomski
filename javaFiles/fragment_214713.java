import java.util.Scanner;
public class test {

    public static void main(String args[]) {

    Scanner val = new Scanner(System.in);
    System.out.print("Enter no of values:");

    int n;
    int A[] = new int[n=val.nextInt()];
    //First constraint  
    if(n>=1 && n<=100)     
    {

       for(int i=0;i<A.length;i++)
      {
          A[i]=val.nextInt();
      }

     for(int i=0;i<A.length;i++) 
      {  //Second constraint loop through all elements of A[]   
         // if one of it does not obey constraint exit the program

        if(A[i]<=0 || A[i]>=1000) // notice here I change '>' 
       {
        System.exit(0);       // this else is attached to your second constraint
       }
      }

      for(int i = 0; i < A.length; i++){
         int sum=0; 
         //Using for-each loop to print array values and get total sum
         for(int t:A) 
         {      
            System.out.print(t+" ");
            sum+=t;
         }  
        //To get largest value
        int largest=A[0];
        for(int j=0;j<A.length;j++)//i=1 can work 
        { 
            if(A[j]>largest)
            {
               largest=A[j];    
            }
        }
        //To get and print remainder
        int rem;
        rem=sum%largest;
        System.out.println(rem);

      }
    }
   }
}