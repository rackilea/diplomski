ArrayList<String> keys = new ArrayList<String>();
keys.add("username");
keys.add("on");
String startDelimiter = ";";
String endDelimiter = ";";
String searchStr = "A user with username ;suren; logged into the system on ;Thu May 2, 2013 2:30pm;";       
for (String key : keys) {
    Pattern p = Pattern.compile("("+key+")[ ]+?"+startDelimiter+"([^;]+)"+endDelimiter);
    Matcher m = p.matcher(searchStr);   
    while( m.find() ) {
        System.out.println("Key: "+m.group(1)+" Value: "+m.group(2));
    }
}