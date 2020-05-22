String s = "# #.id\nendpoint/?userId=#someuser.id\nHi #someuser.name, how are you?";
String regex = "#[^.#]*[^.#\\s][^#.]*\\.\\w+";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group(0)); 
}