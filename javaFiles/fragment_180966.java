public static String replaceToken(String primary, String secondary, char token) {

   char [] charArray =primary.toCharArray();

   int counter = 0;
   for(int i=0; i<charArray.length; i++){
       if(charArray[i]==token){
           charArray[i] = secondary.charAt(counter);
           counter++;
           if(counter>=secondary.length()) break;
       }
   }
   return new String(charArray);
}    


public static void main(String[] args) {       
   String result = replaceToken("111TTT0000TT11T00", "001101", 'T');
}