String str = "user1 home1";
Pattern pt = Pattern.compile("(.*)\\s+(.*)");
Matcher matcher = pt.matcher(str);
if (matcher.find()) {
    System.out.println("Group1: [" + matcher.group(1) + "] Group2: [" + matcher.group(2) + ']');
}