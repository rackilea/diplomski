String regex = "(.*?)(>=|<=|<>|>|<)(.*)";
String string = "FEES >= 200";            
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(string);
if(matcher.find()) {
    System.out.println("Splitted Relational Operator: " + matcher.group(2));
    System.out.println("Group 1: " + matcher.group(1) + " group 3: " + matcher.group(3));
}