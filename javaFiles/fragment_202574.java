public class RegionMapOrig {
    private Map<String, String> map;

    public RegionMapOrig() {
        init();
    }

    private void init() {
        map = new HashMap<>();
        map.put("US_A_B", "1");
        map.put("US_A_*", "2");
        map.put("US_*_*", "3");
        map.put("US_O_O", "4");
        map.put("US_*_W", "5");
        map.put("ASIA_*_*", "6");
    }

    public String search(String reg, String s1, String s2) {
        String val = null;
        val = map.get(reg + "_" + s1 + "_" + s2);
        if (val == null) {
            val = map.get(reg + "_" + s1 + "_*");
            if (val == null) {
                val = map.get(reg + "_" + "*_" + s2);
                if (val == null) {
                    val = map.get(reg + "_*_*");
                }
            }
        }
        return val;
    }
}

private static final int N = 1000000000;

public static void main(String[] args) {
    String region = "US";
    String s1 = "O";
    String s2 = "P";

    testOrig(region, s1, s2);
    test(region, s1, s2);
}

private static void testOrig(String region, String s1, String s2) {
    RegionMapOrig map = new RegionMapOrig();

    long start = System.nanoTime();

    for (int i = 0; i < N; ++i) {
        String val = map.search(region, s1, s2);
    }

    long end = System.nanoTime();
    System.out.println((end - start) / 10E9);
}

private static void test(String region, String s1, String s2) {
    RegionMap map = new RegionMap();

    long start = System.nanoTime();

    for (int i = 0; i < N; ++i) {
        String val = map.search(region, s1, s2);
    }

    long end = System.nanoTime();
    System.out.println((end - start) / 10E9);
}