String line = "gulevskaia";
  String pattern = "(^g+(yu|u|y)l+(io|e|ye|yo|jo|ye)(v|b|w)+(s|c)+(k|c)+a(ya|ia|ja|a|y)(a)*)";


  Pattern r = Pattern.compile(pattern);
  Matcher m = r.matcher(line);

  if (m.find( )) {
     System.out.println("Found value: " + m.group(0) );
     char chars[] =m.group(0).toCharArray();
     for(int i=0;i<chars.length;i++)
         System.out.println(chars[i]);

  }