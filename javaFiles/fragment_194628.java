public static boolean isPrime(int n) {  
           if (n <= 1) {  
               return false;  
           }  
           for (int i = 2; i <= Math.sqrt(n); i++) {  
               if (n % i == 0) {  
                   return false;  
               }  
           }  
           return true;  
       }  


private static void printPrimeNumbers(){
        for (int i = 0; i < tab.length; i++){
        if(isPrime(tab[i])){ 
        System.out.println(tab[i] + " jest liczbą pierwszą.");
       } 

    }