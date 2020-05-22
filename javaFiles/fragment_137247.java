Pattern pattern = Pattern.compile("\\p{IsLatin}+(?:-\\p{IsLatin}+)*|\\d+");
Matcher matcher = pattern.matcher(inputString);

while (matcher.find()) {
    System.out.println(matcher.group());
}