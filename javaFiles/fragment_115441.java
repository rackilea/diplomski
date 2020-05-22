boolean isPrime; 
 for (int i : a) {     
    isPrime = true;   
    for (int j=2; j<i; j++) {
       if ((i % j)== 0) {                                             
          isPrime=false;     
          break;                   
       }  
     }             

     if(isPrime) {
         System.out.println(Integer.toString(i) + " is Prime");
     }
 }