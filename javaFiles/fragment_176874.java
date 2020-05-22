public static String convert(String str)
 {
   if (str.equals("# "))
      System.out.println(" ");
   Pattern pattern = Pattern.compile("(#+[^#]+)");
   Matcher matcher = pattern.matcher(str);

   while (matcher.find())
   {
       boolean append_p = false;
       char carac;
        for(int i = 0; i < str.length(); i++){
       if(Character.isLetter(str.charAt((i)))){
           if (Character.isUpperCase(str.charAt(i)))
           {
              System.out.print("<p>");
              append_p = true;
              break;
           }
       }else{
           append_p = false;
       }
   }
      String str1 = matcher.group(1);
      if (str1.replaceFirst("#+", "").length() == 0 || str1.replaceFirst("#+", "").matches("[\\s]+"))
         continue;
      int n = str1.length() - str1.replaceFirst("#+", "").length();
      System.out.print("<h" + n + ">" + str1.substring(n) + "</h" + n + ">");
      if(append_p == true){ System.out.print("</p>"); append_p = false;}
   }
   if(Character.isUpperCase(str.charAt(0)){
      System.out.println("<p>"+str+"</p>");
   return ("");
 }