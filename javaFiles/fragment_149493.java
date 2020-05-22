Map<String, List<String>> mx = new HashMap<>(map1);
map2.forEach((k, v) -> mx.merge(k, v, (l1, l2) -> {
    List<String> l = new ArrayList<>(l1);
    l.addAll(l2);
    return l;
}));