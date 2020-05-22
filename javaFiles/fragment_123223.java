String string = "$item1$={key1=1,key2=2,key3=3,}"+
                   "$item2$={key10=4,key11=5,key3=4,key9=7,}"+
                   "$itemN$={keyi-1=5,keyi=3,}";
HashMap<String,HashMap<String,Integer>> myMap = new HashMap<String,HashMap<String,Integer>>();
Pattern itemPattern = Pattern.compile("([^\\s{}]+)=\\{([^{}]+)\\}");
Matcher itemMatcher = itemPattern.matcher(string);
while(itemMatcher.find()) {
    HashMap<String,Integer> item = new HashMap<String,Integer>();
    String itemName = itemMatcher.group(1);
    String itemContent = itemMatcher.group(2);
    Pattern kvPattern = Pattern.compile("([^=,]+)=([^=,]+)");
    Matcher kvMatcher = kvPattern.matcher(itemContent);
    while(kvMatcher.find()) {
        item.put(kvMatcher.group(1), Integer.parseInt(kvMatcher.group(2)));
    }
    myMap.put(itemName, item);
}
System.out.println(myMap.toString());