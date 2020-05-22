String str="cccd";
String regex="(?=(c+d))";
Pattern pattern = Pattern.compile(regex);
Matcher matcher =pattern.matcher(str);
while(matcher.find()){
    System.out.println(matcher.group(1));
}