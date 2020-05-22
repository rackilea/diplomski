String str2 = "/EMOTIONS_TAX/29027000/Points Of Interest/totem,"
                  + "/EMOTIONS_TAX/29044000/Places/Italia,"
                  + "/EMOTIONS_TAX/29027000/Military Equipment";

    Pattern pattern = Pattern.compile("\\d+");
    Matcher matcher = pattern.matcher(str2);
    while(matcher.find()) {
        System.out.println(matcher.group());
    }