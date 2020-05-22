static Pattern pattern = Pattern.compile("[|]([*_@=])[^|]+\\1[|]");

public static List<Integer> getMatchedIntexes(String s) {
    List<Integer> result = new ArrayList<>();
    Matcher m = pattern.matcher(s);
    while (m.find()){
        result.add(m.start()+1);//index of character after `|`
        result.add(m.end()-1);  //index of character before `|`
    }

    return result;
}