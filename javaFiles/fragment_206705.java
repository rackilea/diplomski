List<Code> codes = ...;
Map<Integer, List<Code>> grouped = new HashMap<>();
for (Code code : codes) {
    if (! grouped.containsKey(code.getInterface()) {
        grouped.put(code.getInterface(), new ArrayList<Code>());
    }
    grouped.get(code.getInterface()).add(code);
}