List<String> strs = Arrays.asList("ABC", "ASD*ABC", "JULY*ABC*RTEW", "ASDABC");
Pattern p = Pattern.compile("(?<=^|\\*)ABC(?=$|\\*)");
for (String str : strs) {
    Matcher m = p.matcher(str);
    System.out.println("\"" + str + "\" => " + m.find());
}