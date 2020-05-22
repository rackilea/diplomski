Map<Integer,String> map = new HashMap<>(); //this map contains the values
map.put(3, "Mr Foo");
map.put(0, "Mr Boo");
map.put(1, "cake");
map.put(2, "cookie");

String query = "hello ? would you like a ? or a ? from ?"; //this is the query

Matcher matcher = Pattern.compile("\\?").matcher(query);
int index = 0;
StringBuffer sb = new StringBuffer();
while(matcher.find()){ 
    matcher.appendReplacement(sb, map.get(index));
    index++;
}
matcher.appendTail(sb);
System.out.println(sb.toString()); // this will display the query as you want