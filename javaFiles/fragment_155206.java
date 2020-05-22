String str="<actions>::=<action><action>|X|<game>|alpha";
str=str.split("=")[1];
Pattern pattern = Pattern.compile("<.*?>|\\|.*?\\|");
Matcher matcher = pattern.matcher(str);
while (matcher.find()) {
    System.out.println(matcher.group());
}