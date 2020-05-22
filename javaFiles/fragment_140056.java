String str = "1   (201, <202,203>), (203, <204,208>), (204, <>)";
   Pattern p = Pattern.compile("(\\d+)");
   Matcher m = p.matcher(str);
   while(m.find())
   {
       System.out.println(m.group(1));
   }