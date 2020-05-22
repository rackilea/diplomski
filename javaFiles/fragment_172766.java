String src = "(Buy) 655500 - (Sell) 656500";
    String reg = "[0-9]+";
    Pattern pattern = Pattern.compile(reg);
    Matcher matcher = pattern.matcher(src);
    while(matcher.find()) {
       System.out.println(matcher.group());
    }