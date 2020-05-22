public boolean isNumeric(String str) 
{
   Pattern p = Pattern.compile("[0-9]+");
   Matcher m = p.matcher(str);
   return m.matches();
}