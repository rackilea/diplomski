class Test {
public static void main (String[] args) {
    Set<String> strs = new HashSet<String>(Arrays.asList("apple", "orange"));

    //Convert to list
    LinkedList<String> strsList = new LinkedList<String>();
    strsList.addAll(strs);

    //Do modification
    for (int i = 0; i < strsList.size(); i++) {
        String str = strsList.get(i);
        strsList.set(i,"i" + str);
    }

    //Convert back to set
    strs.clear();
    strs.addAll(strsList);
    }
}