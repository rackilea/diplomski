String s = "start{3}{3}{3}{3}end";
    String pString = "\\{3\\}";
    Pattern p = Pattern.compile(pString);
    Matcher m = p.matcher(s);

    int count = 0;
    while (m.find()) {
        count++;
    }
    System.out.println(s.replaceAll(pString, "-").replaceFirst("-{"+count+"}", "\\$"+count+pString));