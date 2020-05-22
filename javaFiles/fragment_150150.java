String s = "test test3 t3st test: word%5 test! testing t[st";
Pattern pattern = Pattern.compile("(?<!\\S)\\p{Alpha}+(?!\\S)");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group(0)); 
}