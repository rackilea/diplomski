List<V> vs = map.get(k);
if (vs == null) {
    vs = new ArrayList<>();
    vs.add(v);
    map.put(k, vs);
} else {
    vs.add(v);
}