public static void main(String[] args) throws ReflectiveOperationException {
    init();
    List<String> list = List.of(
        "LBCDD", "IKBNU", "WZQAG", "MKEAZ", "BBCHF", "KRQHE", "ZZMWH", "FHLVH",
        "ZFLXM", "TXXPE", "NSJDQ", "BXDMJ", "OFBCR", "WVSIG", "HQDXY");

    HashMap<String, String> map = new HashMap<>(1, 10.0f);

    for (String s : list) {
        System.out.println("===> put " + s);
        map.put(s, s);
        dumpMap(map);
    }
}