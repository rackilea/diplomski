public double myParseDouble(String s)
{
   double result;
   try
   {
      result = Double.parseDouble(s);
   }
   catch (NumberFormatException nfe)
   {
      result = Double.NaN;
   }
   return result;
}