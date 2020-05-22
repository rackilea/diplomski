//input data
String s = "<tagA>283940</tagA>\n" +
"                    <tagA>& 9940<</tagA>\n" +
"                    <tagA>- 99440</tagA>\n" +
"                    <tagA>< 99440</tagA>\n" +
"                    <tagA>99440</tagA>"
                + "<13243> asdfasdf </>";


    String replaced = s.replaceAll("(\\s{0,})(<\\w+>)(\\D{0,})(\\d+)(\\D{0,})(<\\/\\w+>)(\\s{0,})", "$2$4$6");
    System.out.println(replaced);