private static final Pattern PATTERN = Pattern.compile("[a-zA-Z](?=([a-zA-Z]))");
//                                                      ^^^^^^^^   ^^^^^^^^^^
//                                                       group 0    group 1

//...

Matcher matcher = PATTERN.matcher(myString);
while (matcher.find()){
    String match = matcher.group() + matcher.group(1);
    //...
}