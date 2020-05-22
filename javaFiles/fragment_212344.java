Pattern pattern = Pattern.compile("(?<key>(?<=\\s):\\d\\d[a-zA-Z]):(?<value>.*?)(?=\\s:|$)");
Matcher matcher = pattern.matcher(swiftMessage);
while( matcher.find() ) {
    String key = matcher.group("key");
    String value = matcher.group("value");

    System.out.println(key + "=>" + value);

}