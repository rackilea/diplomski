String input = "I am Duc/N Ta/N Van/N";
Pattern pattern = Pattern.compile("([^\\s]+)/N");
Matcher matcher = pattern.matcher(input);
String result = "";
while (matcher.find()) {
    result+= matcher.group(1) + " ";
}

System.out.println("Name: " + result.trim());