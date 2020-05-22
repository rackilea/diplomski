String line = "A,,B";
ArrayList<String> tokens = new ArrayList<String>();
String regex = "\"([^\"]*)\"|[^,]+|(?<=,)(?=,)";   // <= No need for Group 2
Matcher m = Pattern.compile(regex).matcher(line);
while (m.find()) {
    if (m.group(1) != null) {
        tokens.add(m.group(1));
    } 
    else {
        tokens.add(m.group(0)); // <= Note that we can grab the whole match here
    }
}
System.out.println(tokens);