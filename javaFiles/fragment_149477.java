String s = "AAAhttp://www.gmail.comBBBBabc@gmail.com";
    Pattern p = Pattern.compile("www\\..*?\\.com");
    Matcher m = p.matcher(s);
    while (m.find()) {
      System.out.println(m.group(0));
    }