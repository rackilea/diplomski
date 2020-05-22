String a = "sin(23)+cos(4)+2!+3!+44!";
    Pattern number = Pattern.compile("\\d+!");
    Matcher matcher = number.matcher(a);
    while (matcher.find()) {
        System.out.println(matcher.group());
    }