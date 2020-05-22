String[] tests = { "abc1mgabc","abc100mlabc","abc256kgabc"};
Pattern ptrn = Pattern.compile("(?i)([0-9]+)(gr|kg|mg|ml|g|l)");
for (String s: tests) {
    Matcher matcher = ptrn.matcher(s);
    while (matcher.find()) {
        System.out.println("QNTY: " + matcher.group(1));
        System.out.println("UNIT:" + matcher.group(2));
    }
}