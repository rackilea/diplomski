public static  int GCD(int numerator,int denominator){
         if(numerator < denominator){
                 int numswap=denominator;
                 denominator=numerator;
                 numerator=numswap;
        }
         int remainder=numerator%denominator; 
         if (remainder == 0){
             return denominator;
         }
         System.out.println(numerator+" "+denominator);
         return GCD(denominator, remainder);

    }