public class TopsCollection<D> {

    private final TreeMap<Integer, List<D>> map 
        = new TreeMap<>((lhv, rhv) -> rhv.compareTo(lhv));

    public TopsCollection() {}

    public void add(Integer score, D name) {
        List<D> vals = map.get(score);
        if (vals == null) {
            vals = new ArrayList<>();
            map.put(score, vals);
        }
        vals.add(name);
    }

    public List<D> getTops(int n) {
        return map.
            values().
            stream().
            limit(n).
            reduce(new ArrayList<D>(), (lhv, rhv) -> {
                lhv.addAll(rhv);
                return lhv;
            });
    }
}