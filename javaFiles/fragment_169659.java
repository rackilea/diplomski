/****FIRST RUN****/
   // digit = 98%10 = 8
   digit = max%10; 
   // 8 % 2 == 0
   if( digit % 2 == 1 ) 
     sumOdd += digit; 
   // max = 98/10 = 9
   max/= 10; 

   /****SECOND RUN****/
   // digit = 9%10 = 9
   digit = max%10; 
   // 9 % 2 == 1
   if( digit % 2 == 1 ) 
     // sumOdd = 1
     sumOdd += digit; 
   // max = 9/10 = 0
   max/= 10;