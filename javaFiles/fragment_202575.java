public String searchNoCat(String cache1, String cache2, String cache3,  String cache4) {
    String val = null;
    val = map.get(cache1);
    if (val == null) {
        val = map.get(cache2);
        if (val == null) {
            val = map.get(cache3);
            if (val == null) {
                val = map.get(cache4);
            }
        }
    }
    return val;
}

private static void testOrigNoCat(String region, String s1, String s2) {
    RegionMapOrig map = new RegionMapOrig();

    String cache1 = region + "_" + s1 + "_" + s2;
    String cache2 = region + "_" + s1 + "_*";
    String cache3 = region + "_" + "*_" + s2;
    String cache4 = region + "_*_*";

    long start = System.nanoTime();

    for (int i = 0; i < N; ++i) {
        String val = map.searchNoCat(cache1, cache2, cache3, cache4);
    }

    long end = System.nanoTime();
    System.out.println((end - start) / 10E9);
}