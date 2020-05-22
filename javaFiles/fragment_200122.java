String regEx = "([^\\s]*)-([^\\s]*)";
    String s= "Fla-t  3-a Butte -rfl-y Street-";
    Pattern pattern = Pattern.compile(regEx);
    Matcher matcher = pattern.matcher(s);

    while (matcher.find()) {
        System.out.println(matcher.group());
    }