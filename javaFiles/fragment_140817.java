Map<String, Set<String>> data = new HashMap<>();
data.put("accounts", new HashSet<>(Arrays.asList("ADMIN", "CONSULT")));
data.put("merchants", new HashSet<>(Arrays.asList("MANAGER", "ADMIN")));

Set<String> values = new HashSet<>();
for (Set<String> set : data.values()) {
    values.addAll(set);
}