String s =
        "IF (A=3 AND B=2)=0 AND IF(c=4 AND D=5)=1 AND (AGE>=15 AND AGE<=45)";
    Pattern exprPattern = Pattern.compile("(IF\\s*\\(.*?\\)=[01]|\\(.*\\))");
    Matcher m = exprPattern.matcher(s);
    while (m.find()) {
        System.out.println("* " + m.group());
    }