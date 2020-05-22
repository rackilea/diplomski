String s = "(1)name1:content1(2)name2:content2(3)name3:content3...(4)namen:content4";
Pattern pattern = Pattern.compile("\\(\\d+\\)([^:]+):([^(]*(?:\\((?!\\d+\\))[^(]*)*)");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group(1));
    System.out.println(matcher.group(2)); 
}