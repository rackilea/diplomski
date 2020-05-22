String raw = "The most popular fruits were apples and bananas "
        + "(see section ‘\\u0013 HYPERLINK \\l \"_Common_fruit_types\\\" "
        + "\\u0001\\u0014Common fruits\\u0015’ and subsection ‘\\u0013 HYPERLINK \\l"
        + "\\\"_Botanic_description\\\" "
        + "\\u0001\\u0014Detailed botanic descriptions\\u0015’ below).";

// test
System.out.printf("Raw string: %s%n%n", raw);
//                           | escaped back slash
//                           | | escaped unicode point
//                           | |      | any 1+ character, reluctant
//                           | |      |  | escaped \ and unicode point
//                           | |      |  |        | group 1: your goal
//                           | |      |  |        |    | escaped final \ + unicode point
Pattern p = Pattern.compile("\\\\u0013.+?\\\\u0014(.+?)\\\\u0015");
Matcher m = p.matcher(raw);
while (m.find()) {
    System.out.printf("Found: %s%n", m.group(1));
}
System.out.println();

// actual replacement
System.out.printf(
    "Replaced: %s%n", 
    raw.replaceAll("\\\\u0013.+?\\\\u0014(.+?)\\\\u0015", "$1")
);