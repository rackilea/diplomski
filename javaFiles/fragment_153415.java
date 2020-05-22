public static void Methods(int a){
   int loops = a/2;
   int even = 0;

   for(int i = 0; i < loops; i++){
       even+=2;

       System.out.print(even);
       if (i < loops - 1) {
           System.out.print(" and ")
       }
   }