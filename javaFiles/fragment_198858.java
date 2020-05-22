@Override
public List<String> getCacheFiles() {
    List<String> list = new ArrayList<String>(1);
    list.add(ipAsnFile + "#GeoIPASNum.dat");
    return list;
}