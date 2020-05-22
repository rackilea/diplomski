public static String[] splitIncludeDelimeter(String regex, String text){
    List<String> list = new LinkedList<>();
    Matcher matcher = Pattern.compile(regex).matcher(text);

    int now, old = 0;
    while(matcher.find()){
        now = matcher.end();
        list.add(text.substring(old, now));
        old = now;
    }

    if(list.size() == 0)
        return new String[]{text};

    //adding rest of a text as last element
    String finalElement = text.substring(old);
    list.add(finalElement);

    return list.toArray(new String[list.size()]);
}