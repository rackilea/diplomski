Collections.sort(inStrings, new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        return s1.compareToIgnoreCase(s2); // if you don't care about uppercase and lowercase;
    }
});