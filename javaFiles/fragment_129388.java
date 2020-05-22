public static int find(String s, ArrayList<String> a) {
    int count = 0;
    for (String str : a) {
        if (str.equalsIgnoreCase(s))
            count++;
    }
    return count;
}