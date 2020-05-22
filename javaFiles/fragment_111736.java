String line = "XYZ Q|1|^123456<CR>";
Pattern queryRegex=Pattern.compile("Q\\|\\d\\|(.+?)<CR>");

Matcher queryMatcher=queryRegex.matcher(line);
if (queryMatcher.find()) {
    System.out.println("Group 0: " + queryMatcher.group(0));
    System.out.println("Group 1: " + queryMatcher.group(1));
}