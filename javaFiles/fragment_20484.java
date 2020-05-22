public int[] getElementsAsArray(String aString){
       int[] digits = new int[aString.length()];
       for(int i=0;i<aString.length();i++){
           digits[i]=Integer.parseInt(""+aString.charAt(i));
       }
       return digits;
   }