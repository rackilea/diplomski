public static void main(String[] args) {

    StringBuilder str = new StringBuilder("<div id=\"contentPermission\">"
            + "  [[MI44,MI304,MI409,MI45,MI264,MI108,MI46,MI47,MI48,MI49,MI50,MI51,MI52,MI58,MI530]]"
            + "</div><div>&nbsp;</div><p>&nbsp;</p><div>&nbsp;</div><p>&nbsp;</p><p>[[LP1137]]</p>");

    System.out.println("Before " + str.toString()+"\n\n\n");

    Pattern pattern = Pattern.compile("\\[{2}.[^\\]]*\\]{2}");
    Matcher matcher = pattern.matcher(str);

    while(matcher.find()){

        String codes = matcher.group(0);
        codes = codes.substring(2, codes.length()-2);

        StringBuilder urls = new StringBuilder();
        for(String code:codes.split(",")){
            urls.append("<a href=\"index?page=content&id=" + code + "></a>\n");
        }
        str = new StringBuilder(matcher.replaceFirst(urls.toString()));
        matcher = pattern.matcher(str);
    }

    System.out.println("Replaced " + str.toString());
}