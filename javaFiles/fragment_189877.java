String regex = "\\b(array|as|asm|begin|case|class|const|constructor|destructor|dispinterface|div|do|downto|else|end|except|exports|file|finalization|finally|for|function|goto|if|implementation|inherited|initialization|inline|interface|is|label|library|mod|nil|object|of|out|packed|procedure|program|property|raise|record|repeat|resourcestring|set|shl|shr|string|then|threadvar|to|try|type|unit|until|uses|var|while|with)\\b" +
              "|(=|<[>=]?|>=?)" +
              "|\\b(and|not|or|xor)\\b";
for (Matcher m = Pattern.compile(regex).matcher(line); m.find(); ) {
    if (m.start(1) != -1) {
        System.out.println("Keyword\t\t" + m.group(1));
    } else if (m.start(2) != -1) {
        System.out.println("logic_op\t\t" + m.group(2));
    } else {
        System.out.println("relational_op\t\t" + m.group(3));
    }
}