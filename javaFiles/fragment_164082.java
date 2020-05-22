if (i >= 'a' && i <= 'z') { 
   i += 9; 
   if (i > 'z') { 
       int newChar = 96 + (i - 'z'); 
       System.out.print((char) newChar); 
   } 
   System.out.print((char) i);
 }