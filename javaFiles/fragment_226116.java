Collections.sort(list, new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        if (/* s1 is lower case and s2 is upper case */) {
            return 1;
        }

        if (/* s1 is upper case and s2 is lower case */) {
            return -1;
        }

        return s1.compareTo(s2);
    }
});