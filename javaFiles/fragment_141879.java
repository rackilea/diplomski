public boolean containsIllegalChar(String testWord){
boolean containsIllegalChar = false;

for(int count=0; count < testWord.length(); count++){
     char testChar = testWord.charAt(count);
     switch (testChar)
     {
     case ''': containsIllegalChar = true;
     break;
     case '"': containsIllegalChar = true;
     break;
     case '$': containsIllegalChar = true;
     break;
     case ' ': containsIllegalChar = true;
     break;
     default: break;
     }
}
return containsIllegalChar;
}