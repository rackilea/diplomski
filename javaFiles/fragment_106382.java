int size = colAvgs.length;
for (int a =0;a<size;a++)
 {
  remainder = colAvgs[a];
   while(remainder>0 && a<size)
    {
     remainder = remainder%2;
     if ((remainder%2)==0|| (remainder%2)==1)
      {
       convbases[a] = Integer.toString(remainder);
       a++;
      }//end if
    }//end while
 }//end for
if(remainder>0) //you know it finished due to a being too big.
else //this is what you want to happen