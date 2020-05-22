private static Boolean isDivisibleBy2(int[] x){
         int lastDigit=x[x.length-1];
         if(lastDigit==0 || lastDigit==2 || lastDigit==4 || lastDigit==6 || lastDigit==8)
           return true;
        else
           return false;
}