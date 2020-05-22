String x = new String("string that contains Directions and Photograph. ");
Pattern pattern = Pattern.compile("Directions(.*?) Photograph");
Matcher matcher = pattern.matcher(x); 
while (matcher.find()) {
System.out.println(matcher.group(1));
}