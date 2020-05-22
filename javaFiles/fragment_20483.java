public String reverseString(String aString){
       String reverseString = "" ;
       int index = aString.length()-1;
       while(index >= 0){
           char myCharacter = aString.charAt(index);
           reverseString = reverseString.concat(""+myCharacter) ;
           index--;
       }
       return reverseString;
   }