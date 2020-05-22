String str= "animal 1 animal";

    Pattern p = Pattern.compile("-?\\d+");

    Matcher match = p.matcher(str);

    while (match.find()) {
        System.out.println(match.group());
    }