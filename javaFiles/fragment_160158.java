static {
    Set<Integer> set = new HashSet<>();
    for (UniqueCodes code : values()) {
        if (!set.add(code.value)) {
            throw new RuntimeException(String.format(
                "%s enum contains a non unique code %s",
                UniqueCodes.class.getName(), code.value));
        }
    }
}