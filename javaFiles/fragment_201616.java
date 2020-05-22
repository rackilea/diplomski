String s = "a < b > c > d";
    String regex = "(?=(\\w{1}\\s{1}[<>]{1}\\s{1}\\w{1})).";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(s);
    while(m.find()) {
        System.out.println(m.group(1));
    }