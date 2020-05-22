int max = i;

 for(int j = i+1; j < 1; j++)
 {
   if (wholeNumber[j] > wholeNumber[max])
   {  
      max = j; // NOT: int max = j;
   }
 }