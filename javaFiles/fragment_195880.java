String p = "\\b (?=[\\dPEUCG])  # to jump quickly at interesting positions       \n" +
           "(?=     # open a lookahead                                           \n" +
           "    (?> [\\d,]+ \\s* )? # perhaps the value is before                \n" +
           "    (?<currency> PLN|EUR|USD|CHF|GBP )  # capture the currency       \n" +
           "    (?:\\b|\\d) # a word boundary or a digit                         \n" +
           ")       # close the lookahead                                        \n" +
           "(?> [B-HLNPRSU]{3} \\s* )? (?<value> \\d+(?:,\\d+)? )                  ";

Pattern RegComp = Pattern.compile(p, Pattern.COMMENTS);

String s = "USD 1150,25 randomtext \n" +
           "Non works randomtext 1150,25 USD randomtext\n" +
           "Works randomtextUSD 1150,25 USD randomtext\n" +
           "Works randomtext USD 1150,25 randomtext\n" +
           "Works randomtext USD1150,25 randomtext\n" +
           "Non work randomtext 1150,25 USD randomtext";

Matcher m = RegComp.matcher(s);

while( m.find() ) {
    System.out.println(m.group("value") + " : " + m.group("currency"));
}