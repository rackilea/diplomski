public class Substr {
    public static void main(String[] args) {
        System.out.println(getHistogram("ababaca", 5));
        System.out.println(getHistogram("ababaca", 4));
        System.out.println(getHistogram("ababaca", 3));
        System.out.println(getHistogram("ababaca", 2));
        System.out.println(getHistogram("ababaca", 1));
    }

    public static Map<String, Integer> getHistogram(String str, int k) {
        Map<String, Integer> hmap = new HashMap<>();
        for (int start = 0; start < str.length() - k + 1; start++) {
            String substring = str.substring(start, start + k);
            int count = hmap.containsKey(substring) ? hmap.get(substring) : 0;
            hmap.put(substring, count + 1);
        }
        return hmap;
    }    
}