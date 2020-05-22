static String handleEscape(String input) {

    Pattern p = Pattern.compile("\\$'\\\\x(\\w\\w)'");
    Matcher m = p.matcher(input);

    StringBuffer result = new StringBuffer();

    while (m.find()) {
        m.appendReplacement(result,
            Character.toString((char) Integer.parseInt(m.group(1), 16)));
    }

    m.appendTail(result);

    return result.toString();
}