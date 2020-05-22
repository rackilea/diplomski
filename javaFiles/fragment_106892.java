String str = "/property/33951?year=2017&taxType=RE";
Pattern pattern = Pattern.compile("(?i)year=(\\d+?)&taxType=([A-Z]+)");
Matcher matcher = pattern.matcher(str);
if (matcher.find()) {
    System.out.println("Year = " + matcher.group(1));
    System.out.println("taxType = " + matcher.group(2));
}