Map<String, Map<String, Set<String>>> map1 = new HashMap<>();
Map<String, Map<String, Set<String>>> map2 = new HashMap<>();

map1.put("POne", new HashMap<>());
map1.get("POne").put("PT2", new HashSet<>());
map1.get("POne").get("PT2").add("MN12");
map1.get("POne").put("PT3", new HashSet<>());
map1.get("POne").get("PT3").add("MN13");
map1.put("PTwo", new HashMap<>());
map1.get("PTwo").put("PT3", new HashSet<>());
map1.get("PTwo").get("PT3").add("MN12");
map1.get("PTwo").put("PT4", new HashSet<>());
map1.get("PTwo").get("PT4").add("MN14");

map2.put("POne", new HashMap<>());
map2.get("POne").put("PT2", new HashSet<>());
map2.get("POne").get("PT2").add("MN12");
map2.get("POne").put("PT3", new HashSet<>());
map2.get("POne").get("PT3").add("MN13");
map2.put("PTwo", new HashMap<>());
map2.get("PTwo").put("PT8", new HashSet<>());
map2.get("PTwo").get("PT8").add("MN15");
map2.get("PTwo").put("PT4", new HashSet<>());
map2.get("PTwo").get("PT4").add("MN14");

Map<String, Map<String, Set<String>>> intersection = new HashMap<>(map1);
intersection.entrySet().retainAll(map2.entrySet());

boolean empty = intersection.isEmpty();

System.out.println(empty); // false