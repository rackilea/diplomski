Pattern pattern = Pattern.compile("\\w+ (\\w+)");
Matcher matcher = pattern.matcher("ab cd efg hi jk");

while (matcher.find()) {
    System.out.println("entire match =\t"+matcher.group());
    System.out.println("second word =\t"+matcher.group(1));
    System.out.println("---------------------");
}