class Pair {
    public final boolean booleanValue;
    public final long longValue;

    public Pair(boolean booleanValue, long longValue) {
        this.booleanValue = booleanValue;
        this.longValue = longValue;
    }
}

Map<Long,Pair> map = new HashMap<>();

map.put(1L, new Pair(false, 123));
map.put(2L, new Pair(true,  456));
map.put(3L, new Pair(false, 789));