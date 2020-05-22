String s = "stxt:usa,city:14";
Pattern pattern = Pattern.compile("(stxt|city):([^,]+)");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group(1));
    System.out.println(matcher.group(2));
}