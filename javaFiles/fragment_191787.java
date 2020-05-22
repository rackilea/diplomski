public boolean isNextDigitSame(int valueToCheck) {
// implementation
      int previousDigit = -1;
      while(valueToCheck>0){
          int currentDigit=valueToCheck%10;
          if(currentDigit==previousDigit )
              return true ;
          previousDigit =currentDigit;
          valueToCheck/=10;  
     }
   return false;
}