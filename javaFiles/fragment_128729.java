String str = "one two, three, four five, six seven, eight, nine, ten";

Pattern pattern = Pattern.compile("([^,]+)");

Matcher matcher = pattern.matcher(str);

 while (matcher.find()) {
       System.out.println(trim(matcher.group()));
 }