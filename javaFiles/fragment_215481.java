public static void main(String[] args) {
    Pattern p = Pattern.compile("\"(\\w+)\"|\\b\\d+\\b");
    Matcher m = p.matcher(
        "\"string1\"+\"String2\" >= 10 * function1() / function2()");
    List<String> parts = new ArrayList<String>();
    while (m.find()) {
        if (m.group(1) != null)
            parts.add(m.group(1));
        else
            parts.add(m.group(0));
    }
    System.out.println(Arrays.toString(parts.toArray(new String[] {})));        
}