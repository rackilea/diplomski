String line = "test_string";
Pattern pattern = Pattern.compile("^(.*?)[ ]{4}.*?[ ]{4}(.*)$",Pattern.MULTILINE);
Matcher matcher = pattern.matcher(line);
while (matcher.find()) {
    System.out.println("group 1: " + matcher.group(1));
    System.out.println("group 2: " + matcher.group(2));
}