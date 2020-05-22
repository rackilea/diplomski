// if tweets is a List
Collections.sort(tweets, new Comparator() {
    public int compare (Object t1, Object t2) {
        // might be the wrong way around
        return ((Tweet)t1).getId() - ((Tweet)t2).getId();
    }
}