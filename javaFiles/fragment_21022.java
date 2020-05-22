public static String increment(String number) {
    Pattern compile = Pattern.compile("^(.*?)([9Z]*)$");
    Matcher matcher = compile.matcher(number);
    String left="";
    String right="";
    if(matcher.matches()){
         left = matcher.group(1);
         right = matcher.group(2);
    }
    number = !left.isEmpty() ? Long.toString(Long.parseLong(left, 36) + 1,36):"";
    number += right.replace("Z", "A").replace("9", "0");
    return number.toUpperCase();
}