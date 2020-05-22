public class decryption
{
public static void main(String[] args)
{
 String secretMessage = ":mmZ\\dxZmx]Zpgy";
 System.out.println(decryption(secretMessage, 88));
}//end main

public static String decryption(String s, int n)
{
 int originalChar, decryptedChar;
 String message = "";
 char c;

 for(int i = 0; i < s.length(); ++i)
 {
  c = s.charAt(i);
  decryptedChar = (int)c;
  if(decryptedChar + n > 126)
     originalChar = 32 + ((decryptedChar + n) - 113);
       else
     {originalChar = decryptedChar + n;
     c = c;}
      if (originalChar > 126)
      originalChar = originalChar - 95;
  message = message + (char)originalChar;
 }//end for loop
 return message;
}//end method
}//end class