String unparsed = "[thing.1][thin2g]";
Pattern pattern = Pattern.compile("\\[(.*?)\\]");
Matcher matcher = pattern.matcher(unparsed);
while(matcher.find()){
    System.out.println(matcher.group(1));
}