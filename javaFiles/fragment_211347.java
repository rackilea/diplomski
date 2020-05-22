Comparator<String> priorityBasedComparator = new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        int priority1 = pMap.get(s1.substring(2, 3));
        int priority2 = pMap.get(s2.substring(2, 3));
        return Integer.compare(priority1, priority2);
    }
}
Collections.sort(list, priorityBasedComparator);