public static void main(String[] args) {

    Random randomNums = new Random();

    int count;

    for (int i = 1; i <= 37; i++) { 

      count = randomNums.nextInt(100) + 1;
      System.out.println("number " + count); 
    String dividers = "";
    for (int b = 1; b<=count; b++) {
        if (count % b == 0) {
            dividers += b.toString() +" ";
        }

    }
    // control the print beside loop
    System.out.println("dividers " + dividers);
    // add the control for whether prime
    bool prime = true;
    for (int a = 2; a< count; a++) {
        if (count % a == 0) {
             System.out.println("prime : is not prime");
             // add the control for skip loop
             prime = false;
             break;   
         }
     }
     if(prime){
     System.out.println("prime : is prime");
     }    
   }    
 }