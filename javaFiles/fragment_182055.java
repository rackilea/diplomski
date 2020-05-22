Pattern lastYearIncomePattern = java.util.regex.Pattern.compile("(.+\\{\\s)(([0-9]{1,2}\\.[0-9]{3}\\s){12})");

Matcher matcher = lastYearIncomePattern.matcher(input);
boolean found =matcher.find();
if(found){
  String[] values= matcher.group(2).split("\\s");
}