String s = "Z=1X1+3X2";
    Pattern p = Pattern.compile("([13])");
    Matcher m = p.matcher(s);
    while (m.find()) {
        System.out.println(m.group());
    }