public static void main(String[] args) {
    Map<String, Integer> e = new HashMap<>();
    e.put("Mark", 0);
    increaseCounter(e, "Mark");
    System.out.println(e.get("Mark"));
}

private static void increaseCounter(Map<String, Integer> e, String key) {
    e.merge(key, 1, Integer::sum);
}