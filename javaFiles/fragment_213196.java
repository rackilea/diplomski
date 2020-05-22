Set<X> set = map.get(name);
if (set == null) {
    final Set<X> value = new HashSet<X>();
    set = map.putIfAbsent(name, value);
    if (set == null) {
        set = value;
    }
}