for(int i =7;i>=0; i=i-2){ // i=i-2 because *s are getting incremented by 2
     for(int j =0;j<=7; j++){
         if(j>=i){ // if j >= i then print * else space(" ")
            System.out.print("*");
         }
         else{
            System.out.print(" ");
         }
    }
    System.out.println();// a new line just after printing *s

}