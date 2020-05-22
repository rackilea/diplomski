class StartsWithAny {
    private Set<String> set;

    public StartsWithAny(String[] array) {
        set = new HashSet<String>();
        for (String a : array) {
            set.add(a);
        }
    }

    // returns true if b starts with any strings contained in array
    // with the condition that b.length() <= 2
    public boolean startsWithAny(final String b) {
        if (b.length() > 0 && set.contains(b.substring(0, 1))) {
            return true;
        }

        if (b.length() > 1 && set.contains(b.substring(0, 2))) {
            return true;
        }

        return false;
    }
}