String str="{abc,  def}, {006,  xy,  036}";
    Pattern p = Pattern.compile("\\{(.*?)\\}");
    Matcher m = p.matcher(str);
    while (m.find()) {
      System.out.println(m.group(1));
    }