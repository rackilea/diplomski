String str = "Locaton;RowIndex;maxRows=New York, NY_10007;1;4 ";
    Pattern pattern = Pattern.compile("=(.*?),");
    Matcher matcher = pattern.matcher(str);
    if (matcher.find()) {
        System.out.println(matcher.group(1));
    }