String hello = "body {font-family: Arial, Helvetica, sans-serif; font-style: normal; font-size: 10pt color: #000000; }";
   Pattern pattern = Pattern.compile("\\{(.+?)\\}", Pattern.DOTALL | Pattern.MULTILINE);
   Matcher matcher = pattern.matcher(hello);
   if (matcher.find()) {
        System.out.println(matcher.group(1));
    }