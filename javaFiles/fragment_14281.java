String s = "<a href=\"https://www.facebook.com\" alt=\"Facebook icon\" title=\"Facebook\" target=\"_blank\"></a>";
Matcher m = Pattern.compile("(?:<a|(?<!^)\\G)\\s+(\\w+)=\"([^\"]*)\"")
        .matcher(s);
while (m.find()) {
    System.out.println(m.group(1) + "\t-\t" + m.group(2));
}