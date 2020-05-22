//String s = "(son of X) (Smith),(son of X) Smith"; // son of X
String s = "[Son of X] Smith"; // Son of X
Pattern pattern = Pattern.compile("^[(\\[](.*?)[\\])]");
Matcher matcher = pattern.matcher(s);
if (matcher.find()){
    System.out.println(matcher.group(1)); 
}