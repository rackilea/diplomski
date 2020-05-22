Pattern pattern=Pattern.compile(".*_([0-9_]{10}.*)\\..*");
    public static String extractDate(String in)
     {
         Matcher m=pattern.matcher(in);
         if(m.matches())
            return m.group(1);

         return in;
     }