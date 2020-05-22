public static String entireName(StringBuilder s1, StringBuilder s2, StringBuilder s3)
  {
        System.out.print(s1.toString());
        //insert.s1('4', ' ');//format stuff, not necessary (not a problem)
        System.out.print(s2.toString());
        //etc..
        System.out.print(s3.toString());
        return s1.append(s2).append(s3).toString();
   }