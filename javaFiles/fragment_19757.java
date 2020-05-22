public int compare(String a, String b) {
    if (map.get(a) > map.get(b)) {
        return -1;
    } else if (map.get(a) < map.get(b)) {
        return 1;
    } else {
        return a.compareTo(b);
    }
}