class MyComparator<T> implements Comparator<String> {
    private static String getDescription(String s) {
        // get all String after CODE
        String[] all = s.split(" ", 2);

        // if there is some content
        if (all.length >= 2) 
            // get it in LOWER CASE
            return all[1].toLowerCase();
        else 
            return "";
    }

    public int compare(String s0, String s1) {
        return getDescription(s0).compareTo(getDescription(s1));
    }

}