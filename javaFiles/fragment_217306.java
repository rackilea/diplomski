Matcher m = Pattern.compile("bread(.+?)bread").matcher(s);
if (m.find()) {
    System.out.println(m.group(1));
} else {
    System.out.println("Not enough bread");
}