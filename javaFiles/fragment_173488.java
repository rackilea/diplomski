public static String[] getDistinct(String[] input) {

    Set<String> distinct = new HashSet<String>();
    for(String element : input) {
        distinct.add(element);
    }

    return distinct.toArray(new String[0]);
}