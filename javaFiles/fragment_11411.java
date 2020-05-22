import java.io.*;

 class Ideone
 {
    public static void main (String[] args) throws Exception
    {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());
      int i,j,k,n;

      int[] inp = new int[T];
      for (i = 0; i < T; i++) {
      inp[i] = Integer.parseInt(br.readLine());
      }

     //Find all the primes numbers till the square-root of 10^9.
     int MAX, root, arrLen;
     MAX=1000000000;
     arrLen=(int)Math.sqrt(MAX);  // arrLen=31622 
     boolean[] primes=new boolean[arrLen+2]; // No need to find all the primes numbers till MAX

     primes[0]=primes[1]=false;
     for(i=2;i<arrLen;i++)
           primes[i]=true;


     // Using Sieve of Eratosthenes
    // Square root of 31622 is 177.8
    root=(int)Math.sqrt(arrLen); // root=177
    for(i=2;i<=root;i++)
    {
       if(primes[i])
       {
           n=i*i;
           k=0;

           //arrLen is the length of primes array.
           for(j=n; j<arrLen; k+=1, j=n+(i*k))
                  primes[j]=false;
       }
   }

    int[] ans = new int[T];
    for( i = 0; i < T; i++) {
         n = inp[i];

         if(n%2==1)
         {
             ans[i]=0; // Odd numbers will have 0 even divisors
         }
         else
         {

          int[] facts=new int[50];
          for(k=0;k<50;k++)
              facts[k]=1;

        facts[0]=0; // fact[0] will contain the highest power of 2 that divides n.
        while(n%2==0)
        {
             facts[0]+=1;
             n=n/2;
        }           

        // Prime factorizing n
        j=1;
        for( k=3; k<arrLen; k+=2)
        {
            if(primes[k] && n%k==0)
            {
                while(n%k==0)
               {
                    facts[j]+=1;
                    n=n/k;
               }
               j+=1;
            }
            if(n==1)  // To check if n has been completely divided or not.
               break;
       }

       if(n!=1) // To check if there is any prime factor greater than the square root of MAX.
       {
            facts[j]+=1;
            j+=1;
       }

       int count=1;
       for(k=0;k<j;k++)
            count=count*facts[k];

        ans[i]=count;
       }
}

   for ( i = 0; i < T; i++)
           System.out.println(ans[i]);

     }
 }