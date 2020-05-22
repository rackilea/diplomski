char[] charArray={'A','B','C'}; // Character array initialized
/**
   *Below line will first convert a charArray to string using 
   *String(char[]) constructor and using String class method  
   *split(regularExpression) the converted string will
   *then be splited with empty string literal delimiter which in turn 
   *returns String[] 
   **/
String[] result=new String(charArray).split("");