public void decrypt (StringBuilder text)
{    
   for (int i=0; i<text.length(); i++)
   {
       char ch = text.charAt(i);
       if ('A' <= ch && ch <= 'Z')
       {
           int index =encryptionString.indexOf(ch);
           text.setCharAt(i, ALPHABET.charAt(index));
       }
   }
}