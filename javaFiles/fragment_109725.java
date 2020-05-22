String s = "[key1=value1, key2=value2, key 3= text,value # 3]";
Pattern pattern = Pattern.compile("(\\w[^,=]*)=(.*?)(?=]|,\\s*\\w[^,=]*=)");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println("Key-value pair found:");
    System.out.println(matcher.group(1).trim());
    System.out.println(matcher.group(2).trim()); 
}