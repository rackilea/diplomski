private final List<String> list = new ArrayList<>();

public void addIfNotPresent(String str) {
    if (list.stream().noneMatch(s -> s.equalsIgnoreCase(str))) {
        list.add(str);
    }
}