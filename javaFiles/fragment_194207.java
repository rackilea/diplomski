String s = "Test,Plan";
   if( s.contains(",") ) {
       s = s.replaceAll(",","");
       StringBuilder builder = new StringBuilder(s);
       builder.reverse();
       System.out.println(builder);
   } else {
       System.out.println(s);
   }