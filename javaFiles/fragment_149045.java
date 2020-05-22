public static boolean isNumeric(String string)
{
   try  
   {  
      float f = Float.parseFloat(string);  
   }  
   catch(NumberFormatException nfe)  
   {  
      return false;  
   }  
   return true;  
}