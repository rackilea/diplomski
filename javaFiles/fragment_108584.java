StringBuffer sb=new StringBuffer("I love JAVA");
    Pattern replace = Pattern.compile("love");
    Matcher matcher2 = replace.matcher(sb.toString());
    String s=matcher2.replaceAll("hate");
    System.out.println(sb.toString());
    System.out.println(s);