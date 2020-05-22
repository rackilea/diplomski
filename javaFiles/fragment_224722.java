String regex = "<abhi>(.*)<\\/abhi>";
    String input = "<abhi>foo</abhi>";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(input);
    if (m.find()) {
        System.out.println(m.group(1));
    }