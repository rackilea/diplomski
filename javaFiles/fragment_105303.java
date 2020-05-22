public static class UserComparator implements Comparator<User> {

    private Collator collator = Collator.getInstance(); 

    @Override
    public int compare(User o1, User o2) {
        int compare = compareString(o1.getGroup(), o2.getGroup());
        if (compare == 0) {
            return compareString(o1.getName(), o2.getName());
        }
        return compare;
    }

    private int compareString(String o1, String o2) {
        return collator.compare(o1, o2);
    }

}