String text = "AAAAAAA\nBBBBBBB\nCCCCCCC\n\nDDDDDD.    YYYYYYYYYYYYYYYYYYYYYY                "
    + "\nEEEEE 1234567890                              "
    + "\n\nSome random text\nSome text random\nRandom text\nText \nSome random text\n\n"
    + "ZZZZZZZZZZZZZZZZ\nUUUUUUUUUUUUUUUU";
Pattern p = Pattern.compile(
 // | 6 "D"s
 // |    | actual dot
 // |    |  | some whitespace
 // |    |  |   | 22 "Y"s
 // |    |  |   |    | more whitespace
 // |    |  |   |    |   | optional: 
 // |    |  |   |    |   || 5 "E"s
 // |    |  |   |    |   ||   | whitespace
 // |    |  |   |    |   ||   |  | 10 digits
 // |    |  |   |    |   ||   |  |      | more whitespace including line breaks
 // |    |  |   |    |   ||   |  |      |      | your text
 // |    |  |   |    |   ||   |  |      |      |    | followed by any "Z" sequence
    "D{6}\\.\\s+Y{22}\\s+(E{5}\\s\\d{10}\\s+)?(.+?)(?=Z+)", 
    Pattern.DOTALL
);
Matcher m = p.matcher(text);
if (m.find()) {
    System.out.println(m.group(2));
}