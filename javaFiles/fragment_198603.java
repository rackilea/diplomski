public int compare(String a, String b) {
    if (base.get(a) > base.get(b)) {
        return -1;
    } else if (base.get(a).equals(base.get(b))) {
        return a.compareTo(b);
    } else {
        return 1;
    } // returning 0 would merge keys
}