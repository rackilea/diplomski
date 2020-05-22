public StringSorter() {
    order = new TreeSet<>((o1, o2) -> {
        if (greaterThan.getOrDefault(o1, Collections.emptySet()).contains(o2))
            return 1;
        else if (greaterThan.getOrDefault(o2, Collections.emptySet()).contains(o1))
            return -1;
        else if(o1.equals(o2)) return 0;
        else return -1; //or 1, or o1.compareTo(o2)
    });
}