public static void main(String[] args) {
    Map map = new HashMap();

    map.put("hello", "world");
    map.put(new Integer(1), 1);
    map.put(new Object(), Lists.newArrayList("hello"));

    Map<String, Integer> m =  (Map<String, Integer>) map;
    System.out.println(m);

    Integer i = m.get("hello");// ClassCastException happens at here at runtime
}