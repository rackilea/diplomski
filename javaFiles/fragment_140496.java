public class TestMap implements Comparable<TestMap> {

    private static int counter = 0;
    private int count;

    public TestMap() {
        count = counter++;
    }

    @Override
    public String toString() {
        return count + "";
    }

    @Override
    public int compareTo(TestMap o) {
        return count - o.count;
    }

    public static void main(String[] args) throws Exception {
        ConcurrentSkipListMap<TestMap, String> x = new ConcurrentSkipListMap<>();
        TestMap a = new TestMap();
        TestMap b = new TestMap();
        x.put(a, "A");
        x.put(b, "B");
        System.out.println("Before");
        for (Map.Entry<TestMap, String> entry : x.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " val: " + entry.getValue());
        }

        for (TestMap t : x.keySet()) {
            if (t.count == 0) {
                t.count = 5;
            }
        }
        System.out.println("After");
        for (Map.Entry<TestMap, String> entry : x.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " val: " + entry.getValue());
        }
    }
}