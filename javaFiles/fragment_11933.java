public static void main(String[] args) {
    List<RRR> rrrList = Arrays.asList(new RRR(), new RRR(), new RRR());
    System.out.println(rrrList);
    Stream<Entry<XClas, YClas>> sf = rrrList.stream().map(x -> x.xySets).map(Map::entrySet).flatMap(x -> x.stream());
    Map<ZZZ, List<YClas>> res = sf.collect(Collectors.groupingBy(x -> x.getKey().getZZZ(), Collectors.mapping(Entry::getValue, Collectors.toList())));
    System.out.println(res);
}

public static class RRR {
    static XClas shared = new XClas();
    private Map<XClas, YClas> xySets = new HashMap<>();
    RRR() { xySets.put(shared, new YClas()); xySets.put(new XClas(), new YClas()); }
    static int s = 0; int n = s++; 
    public String toString() { return "RRR" + n + "(" + xySets + ")"; }
}
public static class XClas {
    private ZZZ zzz = new ZZZ();
    public ZZZ getZZZ() { return zzz; }
    public String toString() { return "XClas(" + zzz + ")"; } 
    public boolean equals(Object o) { return (o instanceof XClas) && ((XClas)o).zzz.equals(zzz); }
    public int hashCode() { return zzz.hashCode(); }
}
public static class YClas {
    static int s = 0; int n = s++; 
    public String toString() { return "YClas" + n; }
}
public static class ZZZ { 
    static int s = 0; int n = s++ / 2;
    public String toString() { return "ZZZ" + n; }
    public boolean equals(Object o) { return (o instanceof ZZZ) && ((ZZZ)o).n == n; }
    public int hashCode() { return n; }
}