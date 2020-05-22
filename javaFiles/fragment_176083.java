// Using an IF statement immediately after the unmodified while()
if (number==1)
{
   num[0][0]=1;
}


// or with a loop DO-WHILE
    do
    {
        for(i=number; i>=1; i--)
        {
           if (i%2==1)
           {
             for(j=number-1; j>=0; j--)
              {
                num[i-1][j]=k;
                k++;
              }
           }
           else
              for(j=0; j<=number-1; j++)
              {
                num[i-1][j]=k;
                k++;
              }
         }
   }while(k<(number*number));