if(str.length()>=word.length())
{
   if (str.substring(0, length).equals(word))
      return str.substring(0, length);
   else if (str.substring(1, length).equals(word.substring(1, word.length())))
      return str.substring(0, length);
   else
      return ""; 
}
else{
    return "";  
}