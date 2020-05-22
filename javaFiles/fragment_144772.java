public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("str1");
        list.add("str2");
        list.add("str3");
        list.add("str4");
        final Map<String, Integer> counts = new HashMap<>();
        counts.put("str1", 2);
        counts.put("str2", 3);
        counts.put("str3", 1);
        counts.put("str4", 3);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String left, String right) {
                return Integer.compare(counts.get(left), counts.get(right));
            }
        });

        System.out.println(list);
    }
}